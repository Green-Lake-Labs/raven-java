package com.umbrella.raven.client.exchange;

import com.umbrella.raven.model.exchange.Symbol;

import java.util.ArrayList;
import java.util.List;

public interface ExchangeClient {

    public List<Symbol> getAllSymbols();

    public List<Symbol> getAllSymbolsAmex();

    public List<Symbol> getAllSymbolsNasdaq();

    public List<Symbol> getAllSymbolsNyse();
}
