package com.greenlake.raven.model.financial.earnings;

import lombok.Data;

@Data
public class EarningsDataNotFound implements EarningsData {
    String message;
    public EarningsDataNotFound(String symbol) {
        this.message = "Cash flow data for symbol: " + symbol + " not found in database.";
    }
}
