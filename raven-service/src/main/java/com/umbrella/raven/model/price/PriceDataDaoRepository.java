package com.umbrella.raven.model.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceDataDaoRepository extends JpaRepository<PriceDataDao, Long> {

    PriceDataDao findFirstBySymbolOrderByDateDesc(String symbol);
}
