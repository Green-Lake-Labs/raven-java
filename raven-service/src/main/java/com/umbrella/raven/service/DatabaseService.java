package com.umbrella.raven.service;

import com.umbrella.raven.client.YahooFinanceClient;
import com.umbrella.raven.model.profile.CompanyProfileDao;
import com.umbrella.raven.model.profile.CompanyProfileDaoRepository;
import com.umbrella.raven.model.symbol.TickerSymbolDao;
import com.umbrella.raven.model.exception.LookupException;
import com.umbrella.raven.model.symbol.TickerSymbolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for hydrating the database.
 */
@Service
@AllArgsConstructor
public class DatabaseService {

    @Autowired
    TickerSymbolRepository tickerSymbolRepository;
    @Autowired
    CompanyProfileDaoRepository companyProfileDaoRepository;

    final YahooFinanceClient yahooFinanceClient;

    public List<String> getSymbolsNasdaq() throws LookupException {
        return yahooFinanceClient.getTickerSymbols("nasdaq").getStocks();
    }

    /**
     * Write all ticker symbols from the NASDAQ to the DB.
     */
    public void writeSymbolsNasdaq() throws LookupException {
        this.tickerSymbolRepository.saveAll(
                getSymbolsNasdaq().stream().map(TickerSymbolDao::new)
                    .collect(Collectors.toList())
        );
    }

    public List<String> getSymbolsNyse() throws LookupException {
        return yahooFinanceClient.getTickerSymbols("nyse").getStocks();
    }

    /**
     * Write all ticker symbols from the NYSE to the DB.
     */
    public void writeSymbolsNyse() throws LookupException {
        this.tickerSymbolRepository.saveAll(
                getSymbolsNyse().stream().map(TickerSymbolDao::new)
                        .collect(Collectors.toList())
        );
    }

    /**
     * Write all ticker symbols from the NASDAQ & NYSE to the DB.
     */
    public void writeSymbolsAll() throws LookupException {
        writeSymbolsNasdaq();
        writeSymbolsNyse();
    }

    // TODO: Update all tickers (add new tickers without clearing the DB).
    /**
     * Update all tickers.
     */
    public void updateAllTickers() {
    }

    /**
     * Download company profile info for a certain symbol.
     */
    public void writeProfileInfo(String symbol) {
        this.companyProfileDaoRepository.save(
                new CompanyProfileDao(
                        this.tickerSymbolRepository.findBySymbol(symbol),
                        yahooFinanceClient.getProfileInfo(symbol)
                )
        );
    }

    // TODO: Download all price data for symbol.
    /**
     * Download all price data for symbol.
     */
    public void downloadAllPriceDataForSymbol(String symbol) {
    }

    // TODO: Download all financial data for symbol.
    /**
     * Download all financial data for symbol.
     */
    public void downloadAllFinancialDataForSymbol(String symbol) {
    }
}
