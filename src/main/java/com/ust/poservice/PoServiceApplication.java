package com.ust.poservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@org.springframework.cloud.openfeign.EnableFeignClients
public class PoServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PoServiceApplication.class, args);
	}

}
