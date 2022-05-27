package com.umbrella.raven.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfileRaw {

    @JsonProperty("Sector")
    String sector;
    @JsonProperty("Industry")
    String industry;
    @JsonProperty("Country")
    String country;
    @JsonProperty("State")
    String state;
    @JsonProperty("City")
    String city;
    @JsonProperty("Website")
    String website;
    @JsonProperty("Description")
    String description;
    @JsonProperty("Full Time Employees")
    Long fullTimeEmployees;
    @JsonProperty("Company Name")
    String companyName;
    @JsonProperty("Short Company Name")
    String shortCompanyName;
    @JsonProperty("Exchange")
    String exchange;

}
