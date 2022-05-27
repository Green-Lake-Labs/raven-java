package com.umbrella.raven.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileDaoRepository extends JpaRepository<CompanyProfileDao, Long> {
}
