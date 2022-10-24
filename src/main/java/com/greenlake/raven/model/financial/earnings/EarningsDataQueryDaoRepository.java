package com.greenlake.raven.model.financial.earnings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EarningsDataQueryDaoRepository extends JpaRepository<EarningsDataQueryDao, Long> {
    List<EarningsDataQueryDao> findAllByTickerSymbolDaoSymbol(String symbol);
}
