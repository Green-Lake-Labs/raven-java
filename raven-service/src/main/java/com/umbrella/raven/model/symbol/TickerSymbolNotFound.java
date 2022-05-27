package com.umbrella.raven.model.symbol;

import lombok.Data;

@Data
public class TickerSymbolNotFound implements TickerSymbol {
    String message;
    public TickerSymbolNotFound(String symbol) {
        this.message = "Symbol: " + symbol + "not found in database.";
    }
}
