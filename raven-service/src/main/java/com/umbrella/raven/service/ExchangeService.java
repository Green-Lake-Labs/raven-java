package com.umbrella.raven.service;

import com.umbrella.raven.client.exchange.ExchangeClient;
import com.umbrella.raven.model.exchange.Symbol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for driving the Exchange Client.
 */
@Service
@AllArgsConstructor
public class ExchangeService {


    final ExchangeClient exchangeClient;


    public List<Symbol> getSymbolsAll() {
        return this.exchangeClient.getAllSymbols();
    }

    public List<Symbol> getSymbolsAmex() {
        return this.exchangeClient.getAllSymbolsAmex();
    }

    public List<Symbol> getSymbolsNasdaq() {
        return this.exchangeClient.getAllSymbolsNasdaq();
    }

    public List<Symbol> getSymbolsNyse() {
        return this.exchangeClient.getAllSymbolsNyse();
    }

    public void writeSymbolsAll() {
        for (Symbol symbol: getSymbolsAll()) {
            System.out.println(symbol.toString()); // TODO: Write to Database!
        }
    }

    public void writeSymbolsAmex() {
        for (Symbol symbol: getSymbolsAmex()) {
            System.out.println(symbol.toString()); // TODO: Write to Database!
        }
    }

    public void writeSymbolsNasdaq() {
        for (Symbol symbol: getSymbolsNasdaq()) {
            System.out.println(symbol.toString()); // TODO: Write to Database!
        }
    }

    public void writeSymbolsNyse() {
        for (Symbol symbol: getSymbolsNyse()) {
            System.out.println(symbol.toString()); // TODO: Write to Database!
        }
    }

}
