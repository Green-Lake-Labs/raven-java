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
public class CompanyProfileQueryDao {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "symbol_id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol_id", referencedColumnName = "symbol_id")
    TickerSymbolDao tickerSymbolDao;
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
}
