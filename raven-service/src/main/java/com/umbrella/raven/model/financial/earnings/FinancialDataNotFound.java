package com.umbrella.raven.model.financial.earnings;

import lombok.Data;

@Data
public class FinancialDataNotFound implements FinancialData {
    String message;
    public FinancialDataNotFound(String symbol) {
        this.message = "Cash flow data for symbol: " + symbol + " not found in database.";
    }
}
