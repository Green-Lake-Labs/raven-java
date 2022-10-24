package com.greenlake.raven.model.symbol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerSymbolRepository extends JpaRepository<TickerSymbolDao, Long> {

    TickerSymbolDao findBySymbol(String symbol);
}
