package com.umbrella.raven.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TickerSymbolList {

    List<String> tickerSymbolList;
}
