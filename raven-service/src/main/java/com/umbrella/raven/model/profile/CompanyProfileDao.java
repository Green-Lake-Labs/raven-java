package com.umbrella.raven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_profile")
public class CompanyProfileDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "sector")
    String sector;
    @Column(name = "industry")
    String industry;
    @Column(name = "country")
    String country;
    @Column(name = "state")
    String state;
    @Column(name = "city")
    String city;
    @Column(name = "website")
    String website;
    @Column(name = "description")
    String description;
    @Column(name = "full_time_employees")
    Long fullTimeEmployees;
    @Column(name = "company_name")
    String companyName;
    @Column(name = "short_company_name")
    String shortCompanyName;
    @Column(name = "exchange")
    String exchange;

    public CompanyProfileDao(CompanyProfile companyProfileDao) {
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
