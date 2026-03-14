package com.lpu.rechargeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.rechargeservice.dto.RequestMessageDto;
import com.lpu.rechargeservice.service.RechargeService;

@RestController
@RequestMapping("/recharge")
public class RechargeController {
	@Autowired
	private RechargeService rechargeService;
	
	@PostMapping("/send")
	public String sendRequest(@RequestBody RequestMessageDto message) {
		return rechargeService.sendRequest(message);
		
	}
}
