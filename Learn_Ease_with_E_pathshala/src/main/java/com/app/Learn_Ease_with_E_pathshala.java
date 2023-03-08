package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Learn_Ease_with_E_pathshala {

	public static void main(String[] args) {
		SpringApplication.run(Learn_Ease_with_E_pathshala.class, args);
	}

}
