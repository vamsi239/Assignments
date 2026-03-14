package com.lpu.bank_apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BankApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApigatewayApplication.class, args);
	}

}
