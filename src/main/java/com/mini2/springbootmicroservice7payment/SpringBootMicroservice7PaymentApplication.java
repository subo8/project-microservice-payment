package com.mini2.springbootmicroservice7payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootMicroservice7PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice7PaymentApplication.class, args);
	}

}
