package com.zara.challenge.dto;

import lombok.Getter;

@Getter
public class PricesDto {

    private Long product_id;
    private Long brand_id;
    private String startDate;
    private String endDate;
    private Long priceList;
    private Integer priority;
    private Double price;
    private String currency;

    public PricesDto(Long product_id, Long brand_id, String startDate, String endDate, Long priceList, Integer priority, Double price, String currency) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }
}
