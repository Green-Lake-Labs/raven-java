package com.greenlake.raven.model.profile;

import lombok.Data;

@Data
public class CompanyProfileNotFound implements CompanyProfile {
    String message;
    public CompanyProfileNotFound(String symbol) {
        this.message = "Profile info for symbol: " + symbol + " not found in database.";
    }
}
