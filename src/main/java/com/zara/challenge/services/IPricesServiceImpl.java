package com.zara.challenge.services;

import com.zara.challenge.domain.Prices;
import com.zara.challenge.repository.IPricesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class IPricesServiceImpl implements IPricesService {

    private IPricesRepository iPricesRepository;

    @Autowired
    public IPricesServiceImpl(IPricesRepository iPricesRepository){
        this.iPricesRepository = iPricesRepository;
    }

    @Override
    public Prices getPricing(Long productId, Long brandId, LocalDateTime date) throws NotFoundException {
        Optional<Prices> optional = iPricesRepository.findPricesByDate(productId, brandId, Timestamp.valueOf(date));
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new NotFoundException("not_found");
        }
    }
}
