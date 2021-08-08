package com.zara.challenge.services;

import com.zara.challenge.domain.Prices;
import com.zara.challenge.repository.IPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class IPricesServiceImpl implements IPricesService {

    @Autowired
    private IPricesRepository pricesRepository;

    @Override
    public Prices getPricing(Long productId, Long brandId, LocalDateTime date) {
        return pricesRepository.findPricesByDate(productId, brandId, Timestamp.valueOf(date));
    }
}
