package com.greenlake.raven.model.financial.balancesheet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceSheetDataQueryDaoRepository extends JpaRepository<BalanceSheetDataQueryDao, Long> {
    List<BalanceSheetDataQueryDao> findAllByTickerSymbolDaoSymbol(String symbol);
}
