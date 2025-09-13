package com.in28minutes.microservices.currency_conversion_service.controller;

import com.in28minutes.microservices.currency_conversion_service.entities.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionContrroller {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
	){
		return new CurrencyConversion(1000l,from,to,quantity,BigDecimal.ONE,BigDecimal.ONE,"");
	
	}
}
