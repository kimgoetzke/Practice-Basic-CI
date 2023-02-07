package com.example.PracticeBasicCI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MainTests {
	private final ApplicationContext applicationContext;

	@Autowired
	MainTests(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Test
	void whenAppStarted_thenContextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	void whenCallingTestMe_thenReturnOK() {
		Main application = new Main();
		assertThat(application.testMe()).isEqualTo("OK");
	}
}
