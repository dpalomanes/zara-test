package com.zara.challenge.controllers;

import com.zara.challenge.domain.Prices;
import com.zara.challenge.dto.PricesDto;
import com.zara.challenge.services.IPricesService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class PricesController {

    private IPricesService iPricesService;

    @Autowired
    public PricesController(IPricesService iPricesService) {
        this.iPricesService = iPricesService;
     }

    @GetMapping(value = "/product/{product_id}/brand/{brand_id}/pricing", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PricesDto getPricing(@PathVariable(value = "product_id") String pid, @PathVariable(value = "brand_id") String bid, @RequestParam String date) throws NotFoundException {
        Long productId;
        Long brandId;
        LocalDateTime localDate;

        productId = Long.parseLong(pid);
        brandId = Long.parseLong(bid);
        localDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(Prices.LOCAL_DATE_FORMAT));

        return iPricesService.getPricing(productId, brandId, localDate).getDto();
    }
}
