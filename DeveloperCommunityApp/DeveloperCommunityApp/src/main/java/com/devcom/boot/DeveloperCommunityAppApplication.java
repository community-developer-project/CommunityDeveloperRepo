package com.devcom.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class DeveloperCommunityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperCommunityAppApplication.class, args);
	}

}
