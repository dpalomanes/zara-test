package com.zara.challenge.services;

import com.zara.challenge.domain.Prices;
import com.zara.challenge.repository.IPricesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IPricesServiceImpl implements IPricesService {

    private IPricesRepository iPricesRepository;

    @Autowired
    public IPricesServiceImpl(IPricesRepository iPricesRepository){
        this.iPricesRepository = iPricesRepository;
    }

    @Override
    public Prices getPricing(Long productId, Long brandId, LocalDateTime date) throws NotFoundException {
        List<Prices> pricesList = iPricesRepository.findPricesByDate(productId, brandId, Timestamp.valueOf(date));
        if(pricesList.isEmpty()){
            throw new NotFoundException("not_found");
        } else {
            return getPriorityPrice(pricesList);
        }
    }

    private Prices getPriorityPrice(List<Prices> pricesList) {
        if(pricesList.size() == 1){
            return pricesList.get(0);
        } else {
            Prices priorityPrice = pricesList
                    .stream()
                    .max(Comparator.comparing(Prices::getPriority))
                    .orElseThrow(NoSuchElementException::new);
            return priorityPrice;
        }
    }
}
