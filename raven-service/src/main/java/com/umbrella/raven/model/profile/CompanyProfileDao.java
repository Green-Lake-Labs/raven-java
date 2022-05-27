package com.umbrella.raven.model.profile;

import com.umbrella.raven.model.symbol.TickerSymbolDao;
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
    @Column(name = "profile_id")
    private long id;
    @Column(name = "symbol_id")
    long symbolId;
    @Column(name = "symbol")
    String symbol;
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

    public CompanyProfileDao(TickerSymbolDao tickerSymbolDao, CompanyProfileResponse companyProfileResponse) {
        this.symbolId = tickerSymbolDao.getId();
        this.symbol = tickerSymbolDao.getSymbol();
        this.sector = companyProfileResponse.companyProfile.sector;
        this.industry = companyProfileResponse.companyProfile.industry;
        this.country = companyProfileResponse.companyProfile.country;
        this.state = companyProfileResponse.companyProfile.state;
        this.city = companyProfileResponse.companyProfile.city;
        this.website = companyProfileResponse.companyProfile.website;
        this.description = companyProfileResponse.companyProfile.description;
        this.fullTimeEmployees = companyProfileResponse.companyProfile.fullTimeEmployees;
        this.companyName = companyProfileResponse.companyProfile.companyName;
        this.shortCompanyName = companyProfileResponse.companyProfile.shortCompanyName;
        this.exchange = companyProfileResponse.companyProfile.exchange;
    }
}
