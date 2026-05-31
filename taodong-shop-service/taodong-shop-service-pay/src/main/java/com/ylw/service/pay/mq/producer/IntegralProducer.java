package com.ylw.service.pay.mq.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IntegralProducer {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Transactional
	public void send(JSONObject jsonObject) {
		String jsonString = jsonObject.toJSONString();
		System.out.println("jsonString:" + jsonString);
		String paymentId = jsonObject.getString("paymentId");
		Message message = MessageBuilder.withBody(jsonString.getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8").setMessageId(paymentId)
				.build();
		rabbitTemplate.convertAndSend("integral_exchange_name", "integralRoutingKey", message);
		log.info(">>>消息已发送到MQ: paymentId={}", paymentId);
	}
}