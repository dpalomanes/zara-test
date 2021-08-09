package com.zara.challenge.repository;

import com.zara.challenge.domain.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Optional;

public interface IPricesRepository extends JpaRepository<Prices, Long> {

    @Query("select p from Prices p where p.product.id = ?1 and p.brand.id = ?2 and p.startDate <= ?3 and p.endDate >= ?3")
    Optional<Prices> findPricesByDate(Long productId, Long brandId, Timestamp date);

}
