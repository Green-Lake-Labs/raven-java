package com.greenlake.raven.model.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileDaoRepository extends JpaRepository<CompanyProfileDao, Long> {
}
