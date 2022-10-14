package com.luis.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LuisServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuisServiceDiscoveryApplication.class, args);
	}

}
