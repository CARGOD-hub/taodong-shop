package com.ylw.portal.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class AiCustomerService {

    private static final Logger logger = LoggerFactory.getLogger(AiCustomerService.class);

    @Value("${ai.doubao.api-key:ark-6364207e-ff3d-4eb2-a6eb-630129cdc1cb-280d3}")
    private String apiKey;

    @Value("${ai.doubao.model-id:ep-20260531115448-sgnfq}")
    private String modelId;

    @Value("${ai.doubao.api-url:https://ark.cn-beijing.volces.com/api/v3/chat/completions}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String SYSTEM_PROMPT = "你是淘东电商的智能客服小淘，专业、热情、耐心地为用户服务。\n\n" +
            "你的职责：\n" +
            "1. 商品咨询：介绍产品特点、价格、规格\n" +
            "2. 订单查询：帮助用户查询和处理订单\n" +
            "3. 售后服务：处理退换货、投诉建议\n" +
            "4. 常见问题：解答使用疑问\n" +
            "5. 友好互动：适当开玩笑拉近距离\n\n" +
            "回复要求：\n" +
            "- 语言亲切自然\n" +
            "- 每段回复不超过300字\n" +
            "- 可以适当使用emoji\n" +
            "- 引导用户下单\n" +
            "- 如果用户的问题超出你的知识范围，礼貌地说明并建议联系人工客服";

    public String chat(String userMessage, List<Map<String, String>> chatHistory) {
        try {
            String result = callDoubaoApi(userMessage, chatHistory);
            if (result != null && !result.isEmpty()) {
                logger.info("AI API调用成功，回复长度: {} 字符", result.length());
                return result;
            }
        } catch (Exception e) {
            logger.error("AI API调用失败: {}", e.getMessage());
        }
        logger.info("使用降级回复");
        return getFallbackResponse(userMessage);
    }

    private String callDoubaoApi(String userMessage, List<Map<String, String>> chatHistory) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer " + apiKey);
            headers.add("Content-Type", "application/json");

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", modelId);
            
            List<Map<String, Object>> messages = new ArrayList<>();
            
            Map<String, Object> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", SYSTEM_PROMPT);
            messages.add(systemMessage);
            
            if (chatHistory != null) {
                for (Map<String, String> msg : chatHistory) {
                    Map<String, Object> historyMsg = new HashMap<>();
                    historyMsg.put("role", msg.get("role"));
                    historyMsg.put("content", msg.get("content"));
                    messages.add(historyMsg);
                }
            }
            
            Map<String, Object> userMessageObj = new HashMap<>();
            userMessageObj.put("role", "user");
            userMessageObj.put("content", userMessage);
            messages.add(userMessageObj);
            
            requestBody.put("messages", messages);
            requestBody.put("max_tokens", 500);
            requestBody.put("temperature", 0.7);

            logger.info("调用AI API: {}, model: {}", apiUrl, modelId);
            
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, request, Map.class);
            
            logger.info("API响应状态码: {}", response.getStatusCode());
            
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                Map<String, Object> body = response.getBody();
                
                if (body.containsKey("error")) {
                    String error = body.get("error").toString();
                    logger.error("API返回错误: {}", error);
                    return null;
                }
                
                List<Map<String, Object>> choices = (List<Map<String, Object>>) body.get("choices");
                if (choices != null && !choices.isEmpty()) {
                    Map<String, Object> choice = choices.get(0);
                    Map<String, Object> message = (Map<String, Object>) choice.get("message");
                    if (message != null) {
                        String content = (String) message.get("content");
                        logger.info("API返回内容长度: {}", content != null ? content.length() : 0);
                        return content;
                    }
                }
                
                String output = (String) body.get("output");
                if (output != null && !output.isEmpty()) {
                    logger.info("API返回output内容长度: {}", output.length());
                    return output;
                }
            }
        } catch (RestClientException e) {
            logger.error("RestTemplate调用异常: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("API调用异常: {}", e.getMessage(), e);
        }
        
        return null;
    }

    private String getFallbackResponse(String userMessage) {
        String lowerMessage = userMessage.toLowerCase();
        
        if (lowerMessage.contains("商品") || lowerMessage.contains("产品")) {
            return "您好！我们淘东商城有各种精选商品哦 🛍️！\n\n" +
                    "📦 热门商品推荐：\n" +
                    "- 新鲜水果（烟台苹果、赣南脐橙）\n" +
                    "- 精选肉类（澳洲M12+牛排）\n" +
                    "- 海鲜水产（虾仁、三文鱼）\n\n" +
                    "请问您想了解哪类商品呢？";
        } else if (lowerMessage.contains("订单") || lowerMessage.contains("物流")) {
            return "您好！关于订单查询，请您登录后在「我的订单」中查看哦~ 📋\n\n" +
                    "如有问题，可以联系人工客服：400-888-8888";
        } else if (lowerMessage.contains("退款") || lowerMessage.contains("退货")) {
            return "您好！如需退换货，请按以下步骤操作：🔄\n\n" +
                    "1️⃣ 登录账户，进入「我的订单」\n" +
                    "2️⃣ 找到对应订单，点击「申请售后」\n" +
                    "3️⃣ 填写退换货原因并提交\n\n" +
                    "我们会尽快处理您的申请的！";
        } else if (lowerMessage.contains("你好") || lowerMessage.contains("您好") || lowerMessage.contains("hi")) {
            return "您好！😊 我是淘东电商的智能客服小淘，很高兴为您服务！\n\n" +
                    "请问有什么可以帮助您的呢？\n\n" +
                    "💡 提示：您可以问我关于商品、订单、售后等问题~";
        } else if (lowerMessage.contains("谢谢") || lowerMessage.contains("感谢")) {
            return "不客气！😊 能帮到您我很开心！\n\n" +
                    "如果还有其他问题，随时可以找我哦~";
        } else {
            return "您好！我是小淘 🤖\n\n" +
                    "抱歉，我暂时无法完全理解您的问题。\n\n" +
                    "建议您可以：\n" +
                    "1️⃣ 描述更具体一些\n" +
                    "2️⃣ 联系人工客服：400-888-8888\n\n" +
                    "或者试试问我关于「商品」「订单」「退货」等问题~";
        }
    }
}
