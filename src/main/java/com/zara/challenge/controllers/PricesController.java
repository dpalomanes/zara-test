package com.zara.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PricesController {

    private static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    public PricesController() {
    }

    @GetMapping("/product/{product_id}/brand/{brand_id}/pricing")
    public Map getPricing(@PathVariable(value = "product_id") String pid, @PathVariable(value = "brand_id") String bid, @RequestParam String date){
        Long productId;
        Long brandId;
        LocalDateTime localDate;

        productId = Long.parseLong(pid);
        brandId = Long.parseLong(bid);
        localDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));

        Map map = new HashMap();
        map.put("product", productId);
        map.put("brand", brandId);
        map.put("date", localDate);

        return map;
    }
}
