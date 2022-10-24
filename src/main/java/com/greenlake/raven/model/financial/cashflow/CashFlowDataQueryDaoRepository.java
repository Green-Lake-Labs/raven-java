package com.greenlake.raven.model.financial.cashflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashFlowDataQueryDaoRepository extends JpaRepository<CashFlowDataQueryDao, Long> {
    List<CashFlowDataQueryDao> findAllByTickerSymbolDaoSymbol(String symbol);
}
