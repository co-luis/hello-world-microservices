package com.luis.hello.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	private static final Logger log = LoggerFactory.getLogger(GreetingService.class);

	@Cacheable("greetings")
	public Optional<String> getGreeting(String language) {
		log.info("greeting from memory");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.of("hola");
	}

}
