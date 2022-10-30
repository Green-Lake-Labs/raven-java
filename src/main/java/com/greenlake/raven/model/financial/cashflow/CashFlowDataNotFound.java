package com.greenlake.raven.model.financial.cashflow;

import lombok.Data;

@Data
public class CashFlowDataNotFound implements CashFlowData {
    String message;
    public CashFlowDataNotFound(String symbol) {
        this.message = "Cash flow data for symbol: " + symbol + "not found in database.";
    }
}
