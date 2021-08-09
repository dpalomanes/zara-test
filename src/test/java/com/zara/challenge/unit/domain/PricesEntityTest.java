package com.zara.challenge.unit.domain;

import com.zara.challenge.domain.Brand;
import com.zara.challenge.domain.Prices;
import com.zara.challenge.domain.Product;
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
        Product product = new Product("shirt");
        Brand brand = new Brand("zara");
        Prices prices = new Prices(product, brand, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()), 12345L, 0, 25.9, "EUR");
        this.entityManager.persistAndFlush(product);
        this.entityManager.persistAndFlush(brand);
        Prices savedPriceData = this.entityManager.persistAndFlush(prices);
        assertEquals(savedPriceData.getPrice(), 25.9);

    }
}
