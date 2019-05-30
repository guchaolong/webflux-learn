package com.guchaolong.javalearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class JavaLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaLearnApplication.class, args);
	}
}
