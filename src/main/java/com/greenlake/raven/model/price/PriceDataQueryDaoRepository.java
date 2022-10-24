package com.greenlake.raven.model.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceDataQueryDaoRepository extends JpaRepository<PriceDataQueryDao, Long> {
    List<PriceDataQueryDao> findAllByTickerSymbolDaoSymbol(String symbol);
}
