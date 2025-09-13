package com.in28minutes.microservices.currency_exchange_service.repository;

import com.in28minutes.microservices.currency_exchange_service.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
		CurrencyExchange findByFromAndTo(String from,String to);
}
