package com.luis.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/hello-failover")
@RestController
public class HelloWorldController {
	
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping
	public String sayHello() {
		log.info("saying hello failover");
		return "Hello - fo";
	}

}
