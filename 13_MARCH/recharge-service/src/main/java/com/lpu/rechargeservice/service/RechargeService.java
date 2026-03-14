package com.lpu.rechargeservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.rechargeservice.config.RabbitConfig;
import com.lpu.rechargeservice.dto.RequestMessageDto;

@Service
public class RechargeService {
	@Autowired
	private RabbitTemplate rabitTemplate;
	
	public String sendRequest(RequestMessageDto message) {
		rabitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME,message);
		return "Recharge request sent to queue";
	}
	
}
