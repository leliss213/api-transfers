package com.example.api_transfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiTransfersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTransfersApplication.class, args);
	}

}
