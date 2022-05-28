package com.umbrella.raven.model.financial.earnings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialDataDaoRepository extends JpaRepository<FinancialDataDao, Long> {
}
