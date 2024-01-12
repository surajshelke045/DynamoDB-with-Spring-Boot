package com.dynamo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.dynamo.Repository")
public class DynamoDbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamoDbExampleApplication.class, args);
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Welcome to Dynamo DB";
	}
	
	

}
