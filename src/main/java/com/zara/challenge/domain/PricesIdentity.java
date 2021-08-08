package com.zara.challenge.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PricesIdentity implements Serializable {
    @Column(nullable = false)
    Long product_id;
    @Column(nullable = false)
    Long brand_id;

}
