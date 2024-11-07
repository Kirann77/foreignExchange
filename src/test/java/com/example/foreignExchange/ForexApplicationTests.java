package com.example.foreignExchange;

import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.foreignExchange.repositroy.ForexRateRepository;


@SpringBootTest
public class ForexApplicationTests {
    @MockBean
    private ForexRateRepository repository;

    @Test
    public void testGetLatestRate() {
        // Add test cases here
    }
}

