package com.umbrella.raven.model.financial.financial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialDataQueryDaoRepository extends JpaRepository<FinancialDataQueryDao, Long> {
    List<FinancialDataQueryDao> findAllByTickerSymbolDaoSymbol(String symbol);
}
