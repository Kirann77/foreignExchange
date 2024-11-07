package com.example.foreignExchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foreignExchange.entity.ExchangeRate;
import com.example.foreignExchange.service.ExchangeRateService;

@RestController
@RequestMapping("/fx")
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService service;

    @GetMapping
    public List<ExchangeRate> getExchangeRates(@RequestParam String targetCurrency) {
        return service.getExchangeRates(targetCurrency);
    }

    @GetMapping("fx/{targetCurrency}")
    public List<ExchangeRate> getLatestExchangeRates(@PathVariable String targetCurrency) {
        return service.getLatestExchangeRates(targetCurrency);
    }
}

