package com.umbrella.raven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfile {

    String sector;
    String industry;
    String country;
    String state;
    String city;
    String website;
    String description;
    Long fullTimeEmployees;
    String companyName;
    String shortCompanyName;
    String exchange;

    public CompanyProfile(CompanyProfileDao companyProfileDao) {
        this.sector = companyProfileDao.sector;
        this.industry = companyProfileDao.industry;
        this.country = companyProfileDao.country;
        this.state = companyProfileDao.state;
        this.city = companyProfileDao.city;
        this.website = companyProfileDao.website;
        this.description = companyProfileDao.description;
        this.fullTimeEmployees = companyProfileDao.fullTimeEmployees;
        this.companyName = companyProfileDao.companyName;
        this.shortCompanyName = companyProfileDao.shortCompanyName;
        this.exchange = companyProfileDao.exchange;
    }
}
