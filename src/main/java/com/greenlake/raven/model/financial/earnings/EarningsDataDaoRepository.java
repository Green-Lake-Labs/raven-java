package com.greenlake.raven.model.financial.earnings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningsDataDaoRepository extends JpaRepository<EarningsDataDao, Long> {
}
