package com.zara.challenge.repository;

import com.zara.challenge.domain.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface IPricesRepository extends JpaRepository<Prices, Long> {

    @Query("select p from Prices p where p.identity.product_id = ?1 and p.identity.brand_id = ?2 and p.startDate <= ?3 and p.endDate >= ?3")
    Prices findPricesByDate(Long productId, Long brandId, Timestamp date);

}
