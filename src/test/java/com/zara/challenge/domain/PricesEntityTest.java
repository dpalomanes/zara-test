package com.zara.challenge.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PricesEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void savePrice() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        Product product = new Product("shirt");
        Brand brand = new Brand("zara");
        Prices prices = new Prices(product, brand, timestamp, timestamp, 12345L, 0, 25.9, "EUR");
        this.entityManager.persistAndFlush(product);
        this.entityManager.persistAndFlush(brand);
        Prices savedPriceData = this.entityManager.persistAndFlush(prices);
        assertEquals(savedPriceData.getProduct().getName(), "shirt");
        assertEquals(savedPriceData.getBrand().getName(), "zara");
        assertEquals(savedPriceData.getStartDate(), timestamp);
        assertEquals(savedPriceData.getEndDate(), timestamp);
        assertEquals(savedPriceData.getPriceList(), 12345L);
        assertEquals(savedPriceData.getPriority(), 0);
        assertEquals(savedPriceData.getPrice(), 25.9);
        assertEquals(savedPriceData.getCurrency(), "EUR");
    }
}
