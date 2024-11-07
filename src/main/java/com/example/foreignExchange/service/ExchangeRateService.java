package com.example.foreignExchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foreignExchange.entity.ExchangeRate;
import com.example.foreignExchange.repositroy.ExchangeRateRepository;

@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository repository;

    

    public List<ExchangeRate> getExchangeRates(String targetCurrency) {
    	List<ExchangeRate> list = null;
    	
		return list;
        // Fetch from database or external API logic
    }

    public List<ExchangeRate> getLatestExchangeRates(String targetCurrency) {
        return repository.findTop3ByTargetCurrencyOrderByDateDesc(targetCurrency);
    }
}

