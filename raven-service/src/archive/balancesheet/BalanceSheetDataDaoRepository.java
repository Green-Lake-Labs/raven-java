package com.umbrella.raven.model.financial.balancesheet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceSheetDataDaoRepository extends JpaRepository<BalanceSheetDataDao, Long> {
}
