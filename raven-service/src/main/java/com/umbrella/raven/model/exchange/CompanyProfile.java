package com.umbrella.raven.model.exchange;

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

}
