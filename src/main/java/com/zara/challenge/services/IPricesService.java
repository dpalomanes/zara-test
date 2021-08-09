package com.zara.challenge.services;

import com.zara.challenge.domain.Prices;
import javassist.NotFoundException;

import java.time.LocalDateTime;

public interface IPricesService {
    public abstract Prices getPricing(Long productId, Long brandId, LocalDateTime date) throws NotFoundException;
}
