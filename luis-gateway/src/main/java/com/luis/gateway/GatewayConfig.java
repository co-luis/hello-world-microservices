package com.luis.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
	
	/*
	@Bean
	public RouteLocator configLocalNoEureka(RouteLocatorBuilder builder) {
		return builder.routes().route("hello_route",r->r.path("/api/v1/hello").uri("http://localhost:8080")).build();
		
	}*/
	/*
	@Bean
	public RouteLocator configLocalEureka(RouteLocatorBuilder builder) {
		return builder.routes().route(r->r.path("/api/v1/hello").uri("lb://LUIS-HELLO")).build();
		
	}*/
	

	@Bean
	public RouteLocator configLocalCB(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r
						.path("/api/v1/hello")
						.filters(f->f
								.circuitBreaker(config->config.setName("failoverCB")
								.setFallbackUri("forward:/api/v1/hello-failover")
								.setRouteId("helloFailover")
								)
						)
						.uri("lb://LUIS-HELLO"))
				.route(r->r
						.path("/api/v1/hello-failover")
						.uri("lb://LUIS-HELLO-FAILOVER")
						)
				.build();
		//Consider defining a bean of type 'org.springframework.cloud.gateway.filter.factory.SpringCloudCircuitBreakerFilterFactory' in your configuration.

	}

}
