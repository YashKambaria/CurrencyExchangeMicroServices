package com.in28minutes.microservices.currency_exchange_service.controller;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {
	@GetMapping("/get")
	@Retry(name = "sample-api")
	public String get(){
		log.info("-----------------> Attempted to get data");
		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8010/get", String.class);
		return entity.getBody();
	}
}
