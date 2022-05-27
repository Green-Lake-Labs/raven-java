package com.umbrella.raven.model.profile;

public class CompanyProfileNotFound implements CompanyProfile {
    String message;
    public CompanyProfileNotFound(String symbol) {
        this.message = "Profile info for symbol: " + symbol + "not found in database.";
    }
}
