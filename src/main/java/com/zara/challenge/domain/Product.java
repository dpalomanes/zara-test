package com.zara.challenge.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "product")
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    String name;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Prices> prices;

    public Product() {}

    public Product(String name) {
        this.name = name;
    }
}
