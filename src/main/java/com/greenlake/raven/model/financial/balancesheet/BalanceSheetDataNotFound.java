package com.greenlake.raven.model.financial.balancesheet;

import lombok.Data;

@Data
public class BalanceSheetDataNotFound implements BalanceSheetData {
    String message;
    public BalanceSheetDataNotFound(String symbol) {
        this.message = "Balance sheet data for symbol: " + symbol + " not found in database.";
    }
}
