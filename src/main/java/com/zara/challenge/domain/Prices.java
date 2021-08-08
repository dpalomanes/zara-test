package com.zara.challenge.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "prices")
@Component
public class Prices {

    public static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @EmbeddedId
    PricesIdentity identity;
    @Column(nullable = false)
    Timestamp startDate;
    @Column(nullable = false)
    Timestamp endDate;
    @Column(nullable = false)
    long priceList;
    @Column(nullable = false)
    int priority;
    @Column(nullable = false)
    double price;
    @Column(nullable = false)
    String currency;


    public Map getDto() {
        Map response = new HashMap<String, String>();
        response.put("product_id", String.valueOf(this.identity.product_id));
        response.put("brand_id", String.valueOf(this.identity.brand_id));
        response.put("price_list", String.valueOf(this.priceList));
        response.put("start_date", DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT).format(LocalDateTime.ofInstant(this.startDate.toInstant(), ZoneId.systemDefault())));
        response.put("end_date", DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT).format(LocalDateTime.ofInstant(this.endDate.toInstant(), ZoneId.systemDefault())));
        response.put("price", this.price);
        response.put("currency", this.currency);
        return response;
    }
}
