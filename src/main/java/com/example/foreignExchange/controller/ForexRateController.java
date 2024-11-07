package com.example.foreignExchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foreignExchange.entity.ForexRate;
import com.example.foreignExchange.service.ForexRateService;

@RestController
@RequestMapping("/fx")
public class ForexRateController {
    @Autowired
    private ForexRateService service;

    @GetMapping
    public ResponseEntity<?> getRates(@RequestParam(required = false) String targetCurrency) {
        if (targetCurrency == null) {
            targetCurrency = "EUR";
        }
        ForexRate rate = service.getLatestRate(targetCurrency);
        return ResponseEntity.ok(rate);
    }

    @GetMapping("/{targetCurrency}")
    public ResponseEntity<?> getLatestRates(@PathVariable String targetCurrency) {
        List<ForexRate> rates = service.getLatestRates(targetCurrency);
        return ResponseEntity.ok(rates);
    }
}

