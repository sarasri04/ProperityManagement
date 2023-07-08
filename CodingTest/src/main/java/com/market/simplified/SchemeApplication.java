package com.market.simplified;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SchemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemeApplication.class, args);
	}
//This line added by saranya
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
