package com.example.PracticeBasicCI;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@PostConstruct
	public void init()
	{
		Logger log = LoggerFactory.getLogger(Main.class);
		log.info("App launched.");
	}

	public String testMe() {
		return "OK";
	}
}
