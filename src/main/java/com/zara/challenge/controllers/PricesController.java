package com.zara.challenge.controllers;

import com.zara.challenge.domain.Prices;
import com.zara.challenge.services.IPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PricesController {

    private IPricesService iPricesService;

    @Autowired
    public PricesController(IPricesService iPricesService) {
        this.iPricesService = iPricesService;
     }

    @GetMapping("/product/{product_id}/brand/{brand_id}/pricing")
    public Map getPricing(@PathVariable(value = "product_id") String pid, @PathVariable(value = "brand_id") String bid, @RequestParam String date){
        Long productId;
        Long brandId;
        LocalDateTime localDate;

        productId = Long.parseLong(pid);
        brandId = Long.parseLong(bid);
        localDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT));

        Prices prices = iPricesService.getPricing(productId, brandId, localDate);

        return prices.getDto();
    }
}
