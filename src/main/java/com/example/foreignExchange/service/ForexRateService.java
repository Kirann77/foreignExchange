package com.example.foreignExchange.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.foreignExchange.entity.ForexRate;
import com.example.foreignExchange.repositroy.ForexRateRepository;

@Service
public class ForexRateService {
    @Autowired
    private ForexRateRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public ForexRate getLatestRate(String targetCurrency) {
        return repository.findTopByTargetCurrencyOrderByDateDesc(targetCurrency)
                .orElseGet(() -> fetchAndSaveRate(targetCurrency));
    }

    public List<ForexRate> getLatestRates(String targetCurrency) {
        return repository.findTop3ByTargetCurrencyOrderByDateDesc(targetCurrency);
    }

    @SuppressWarnings("unchecked")
	private ForexRate fetchAndSaveRate(String targetCurrency) {
        String url = "https://api.frankfurter.app/latest?to=" + targetCurrency;
        @SuppressWarnings("rawtypes")
		ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> rates = (Map<String, Object>) response.getBody().get("rates");
        BigDecimal rate = new BigDecimal(rates.get(targetCurrency).toString());

        ForexRate forexRate = new ForexRate();
        forexRate.setDate(LocalDate.now());
        forexRate.setSourceCurrency("USD");
        forexRate.setTargetCurrency(targetCurrency);
        forexRate.setExchangeRate(rate);

        return repository.save(forexRate);
    }
}

