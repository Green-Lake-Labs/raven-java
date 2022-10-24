package com.greenlake.raven.model.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDataDaoRepository extends JpaRepository<PriceDataDao, Long> {

    PriceDataDao findFirstBySymbolOrderByDateDesc(String symbol);
}
