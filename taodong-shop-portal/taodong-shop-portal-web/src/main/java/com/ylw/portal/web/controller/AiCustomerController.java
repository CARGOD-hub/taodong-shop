package com.ylw.portal.web.controller;

import com.ylw.portal.web.service.AiCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/api/ai")
public class AiCustomerController {

    @Autowired
    private AiCustomerService aiCustomerService;

    @PostMapping("/chat")
    public Map<String, Object> chat(@RequestBody Map<String, String> request, HttpSession session) {
        String userMessage = request.get("message");
        
        List<Map<String, String>> chatHistory = (List<Map<String, String>>) session.getAttribute("chatHistory");
        if (chatHistory == null) {
            chatHistory = new ArrayList<>();
        }
        
        String aiReply = aiCustomerService.chat(userMessage, chatHistory);
        
        chatHistory.add(Map.of("role", "user", "content", userMessage));
        chatHistory.add(Map.of("role", "assistant", "content", aiReply));
        
        session.setAttribute("chatHistory", chatHistory);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("reply", aiReply);
        response.put("history", chatHistory);
        
        return response;
    }

    @GetMapping("/history")
    public Map<String, Object> getHistory(HttpSession session) {
        List<Map<String, String>> chatHistory = (List<Map<String, String>>) session.getAttribute("chatHistory");
        if (chatHistory == null) {
            chatHistory = new ArrayList<>();
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("history", chatHistory);
        
        return response;
    }

    @PostMapping("/clear")
    public Map<String, Object> clearHistory(HttpSession session) {
        session.removeAttribute("chatHistory");
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        
        return response;
    }

    @GetMapping("/test")
    public Map<String, Object> testAi() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            String testMessage = "测试AI连接";
            String aiReply = aiCustomerService.chat(testMessage, new ArrayList<>());
            
            response.put("success", true);
            response.put("message", "AI测试成功！");
            response.put("ai_reply", aiReply);
            response.put("is_real_ai", !isFallbackResponse(aiReply));
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "AI测试失败：" + e.getMessage());
        }
        
        return response;
    }
    
    private boolean isFallbackResponse(String reply) {
        String[] fallbackKeywords = {"淘东商城", "订单查询", "申请退款", "我的订单", "人工客服"};
        for (String keyword : fallbackKeywords) {
            if (reply.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
