package com.umbrella.raven.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfile {

    String symbol;
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
        this.symbol = companyProfileDao.symbol;
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

    public CompanyProfile(CompanyProfileQueryDao companyProfileQueryDao) {
        this.symbol = companyProfileQueryDao.tickerSymbolDao.getSymbol();
        this.sector = companyProfileQueryDao.sector;
        this.industry = companyProfileQueryDao.industry;
        this.country = companyProfileQueryDao.country;
        this.state = companyProfileQueryDao.state;
        this.city = companyProfileQueryDao.city;
        this.website = companyProfileQueryDao.website;
        this.description = companyProfileQueryDao.description;
        this.fullTimeEmployees = companyProfileQueryDao.fullTimeEmployees;
        this.companyName = companyProfileQueryDao.companyName;
        this.shortCompanyName = companyProfileQueryDao.shortCompanyName;
        this.exchange = companyProfileQueryDao.exchange;
    }
}
