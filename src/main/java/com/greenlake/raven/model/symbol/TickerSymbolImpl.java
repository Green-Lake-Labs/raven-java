package com.greenlake.raven.model.symbol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TickerSymbolImpl implements TickerSymbol {
    long id;
    String symbol;

    public TickerSymbolImpl(TickerSymbolDao tickerSymbolDao) {
        this.id = tickerSymbolDao.id;
        this.symbol = tickerSymbolDao.symbol;
    }
}
