package com.umbrella.raven.model.financial.income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeDataDaoRepository extends JpaRepository<IncomeDataDao, Long> {
}
