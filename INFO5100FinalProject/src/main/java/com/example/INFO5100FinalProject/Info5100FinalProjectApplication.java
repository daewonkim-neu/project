package com.example.INFO5100FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Info5100FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Info5100FinalProjectApplication.class, args);
	}

}
