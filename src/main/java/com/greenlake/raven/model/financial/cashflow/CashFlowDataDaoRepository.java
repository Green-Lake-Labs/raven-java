package com.greenlake.raven.model.financial.cashflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashFlowDataDaoRepository extends JpaRepository<CashFlowDataDao, Long> {
}
