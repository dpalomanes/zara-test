package com.zara.challenge.services;

import com.zara.challenge.domain.Prices;
import com.zara.challenge.repository.IPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class IPricesServiceImpl implements IPricesService {

    private IPricesRepository iPricesRepository;

    @Autowired
    public IPricesServiceImpl(IPricesRepository iPricesRepository){
        this.iPricesRepository = iPricesRepository;
    }

    @Override
    public Prices getPricing(Long productId, Long brandId, LocalDateTime date) {
        return iPricesRepository.findPricesByDate(productId, brandId, Timestamp.valueOf(date));
    }
}
