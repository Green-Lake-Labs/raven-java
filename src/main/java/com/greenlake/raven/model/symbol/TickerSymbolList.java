package com.greenlake.raven.model.symbol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TickerSymbolList {

    String date;
    String status;
    List<String> stocks;

    public List<String> getTickerSymbolList() {
        return this.stocks;
    }
}
