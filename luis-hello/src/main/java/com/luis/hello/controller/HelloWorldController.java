package com.luis.hello.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.hello.services.GreetingService;

@RequestMapping("/api/v1/hello")
@RestController
public class HelloWorldController {
	
	@Autowired
	private GreetingService greetingService;
	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping
	public ResponseEntity<String> sayHello(@RequestParam("language") String language) {
		log.info("saying hello");
		Optional<String> greeting = greetingService.getGreeting(language);
		if(greeting.isPresent()) {
			return ResponseEntity.ok(greeting.get());
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
