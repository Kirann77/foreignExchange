package com.example.foreignExchange.repositroy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foreignExchange.entity.ForexRate;

public interface ForexRateRepository extends JpaRepository<ForexRate, Long> {
    Optional<ForexRate> findTopByTargetCurrencyOrderByDateDesc(String targetCurrency);
    List<ForexRate> findTop3ByTargetCurrencyOrderByDateDesc(String targetCurrency);
}

