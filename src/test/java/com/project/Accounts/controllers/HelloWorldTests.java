package com.project.Accounts.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloWorldTests {
	
	@Autowired
	private HelloWorld helloWorldController;
	
	@Test
	void controllerReturnsHelloWorld() {
		helloWorldController.hello();
		assertEquals(helloWorldController.hello(), "Hello world");
	}
}
