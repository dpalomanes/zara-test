package com.zara.challenge.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Getter
@Entity
@Table(name = "prices")
@Component
public class Prices {

    public static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @Column(nullable = false)
    Timestamp startDate;
    @Column(nullable = false)
    Timestamp endDate;
    @Column(nullable = false)
    Long priceList;
    @Column(nullable = false)
    Integer priority;
    @Column(nullable = false)
    Double price;
    @Column(nullable = false)
    String currency;

    public Prices() {}

    public Prices(Product product, Brand brand, Timestamp startDate, Timestamp endDate, Long priceList, Integer priority, Double price, String currency) {
        this.product = product;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Map getDto() {
        Map response = new HashMap<String, String>();
        response.put("product_id", String.valueOf(this.product.id));
        response.put("brand_id", String.valueOf(this.brand.id));
        response.put("price_list", String.valueOf(this.priceList));
        response.put("start_date", DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT).format(LocalDateTime.ofInstant(this.startDate.toInstant(), ZoneId.systemDefault())));
        response.put("end_date", DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT).format(LocalDateTime.ofInstant(this.endDate.toInstant(), ZoneId.systemDefault())));
        response.put("price", this.price);
        response.put("currency", this.currency);
        response.put("priority", this.priority);

        return response;
    }

}
