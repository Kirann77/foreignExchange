package com.example.foreignExchange.repositroy;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foreignExchange.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    List<ExchangeRate> findTop3ByTargetCurrencyOrderByDateDesc(String targetCurrency);
    Optional<ExchangeRate> findByDateAndTargetCurrency(LocalDate date, String targetCurrency);
}
