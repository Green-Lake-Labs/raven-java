package com.umbrella.raven.model.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyProfileResponse {
    String date;
    String status;
    CompanyProfileRaw companyProfile;
}
