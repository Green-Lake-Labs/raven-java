package com.umbrella.raven.model.financial.income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeDataQueryDaoRepository extends JpaRepository<IncomeDataQueryDao, Long> {
    List<IncomeDataQueryDao> findAllByTickerSymbolDaoSymbol(String symbol);
}
