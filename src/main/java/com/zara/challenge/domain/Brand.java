package com.zara.challenge.domain;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "brand")
@Component
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    String name;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Prices> prices;

    public Brand() {}

    public Brand(String name) {
        this.name = name;
    }
}
