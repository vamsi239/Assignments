package com.lpu.processingservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.lpu.processingservice.config.RabbitConfig;
import com.lpu.processingservice.dto.RequestMessageDto;

@Service
public class ProcessingService {
	@RabbitListener(queues =RabbitConfig.QUEUE_NAME)
	public void receiveMessage(RequestMessageDto message) {
		System.out.println("Recharge msg received for "+message.getMobileNumber());
	}
	
}
