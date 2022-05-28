package com.umbrella.raven.model.financial.income;

import lombok.Data;

@Data
public class IncomeDataNotFound implements IncomeData {
    String message;
    public IncomeDataNotFound(String symbol) {
        this.message = "Income statement data for symbol: " + symbol + "not found in database.";
    }
}
