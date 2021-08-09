package com.zara.challenge.services;

import com.zara.challenge.domain.Prices;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IPricesServiceImplTest {

    @Autowired
    private IPricesService iPricesService;

    @Test
    public void test_get_single_price() throws NotFoundException {
        Prices prices = iPricesService.getPricing(1L, 1L, LocalDateTime.parse("2020-06-14 18:30:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 25.45, prices.getPrice());
    }

    @Test
    public void test_price_not_found() {
        Exception exception = assertThrows(NotFoundException.class, () -> {
            Prices prices = iPricesService.getPricing(999L, 1L, LocalDateTime.parse("2020-06-14 18:30:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        });

        String expectedMessage = "not_found";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void test_get_max_priority_price() throws NotFoundException {
        Prices prices = iPricesService.getPricing(2L, 1L, LocalDateTime.parse("2020-06-14 10:30:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 15.50, prices.getPrice());
    }

    @Test
    public void test_get_price_for_day_14_10_hs() throws NotFoundException {
        Prices prices = iPricesService.getPricing(1L, 1L, LocalDateTime.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 35.50, prices.getPrice());
    }

    @Test
    public void test_get_price_for_day_14_16_hs() throws NotFoundException {
        Prices prices = iPricesService.getPricing(1L, 1L, LocalDateTime.parse("2020-06-14 16:00:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 25.45, prices.getPrice());
    }

    @Test
    public void test_get_price_for_day_14_21_hs() throws NotFoundException {
        Prices prices = iPricesService.getPricing(1L, 1L, LocalDateTime.parse("2020-06-14 21:00:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 35.50, prices.getPrice());
    }

    @Test
    public void test_get_price_for_day_15_10_hs() throws NotFoundException {
        Prices prices = iPricesService.getPricing(1L, 1L, LocalDateTime.parse("2020-06-15 10:00:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 30.50, prices.getPrice());
    }

    @Test
    public void test_get_price_for_day_16_21_hs() throws NotFoundException {
        Prices prices = iPricesService.getPricing(1L, 1L, LocalDateTime.parse("2020-06-16 21:00:00", DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT)));
        assertEquals( 38.95, prices.getPrice());
    }

}