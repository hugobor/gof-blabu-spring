package com.github.hugobor.gof_blapu_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GofBlapuSpringApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GofBlapuSpringApplication.class, args);
	}

}
