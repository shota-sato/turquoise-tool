package com.example.demo_slack_hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSlackHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSlackHelloApplication.class, args);
		SlackNotifier.send("Spring Boot アプリが起動しました 🎉");
	}

}
