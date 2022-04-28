package com.umbrella.raven.client.exchange;

import com.umbrella.raven.model.exchange.Symbol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface ExchangeClient {

    /**
     * Fetch all companies on the NYSE, NASDAQ, & AMEX.
     */
    List<Symbol> getAllSymbols();

    /**
     * Fetch all companies on the AMEX.
     */
    List<Symbol> getAllSymbolsAmex();

    /**
     * Fetch all companies on the NASDAQ.
     */
    List<Symbol> getAllSymbolsNasdaq();

    /**
     * Fetch all companies on the NYSE.
     */
    List<Symbol> getAllSymbolsNyse();
}
