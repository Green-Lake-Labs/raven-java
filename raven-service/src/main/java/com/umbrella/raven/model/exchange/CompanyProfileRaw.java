package com.umbrella.raven.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfileRaw {

    String date;
    String status;
    CompanyProfile companyprofile;

}
