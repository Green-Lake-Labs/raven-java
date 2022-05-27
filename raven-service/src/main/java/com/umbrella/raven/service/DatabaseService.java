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

    public List<String> getSymbolsNyse() throws LookupException {
        return yahooFinanceClient.getTickerSymbols("nyse").getStocks();
    }

    // TODO: MAKE THIS AN UPDATE, NOT AN OVERWRITE/APPEND!
    /**
     * Write all ticker symbols from the NASDAQ & NYSE to the DB.
     */
    public void writeSymbolsAll() throws LookupException {
        this.tickerSymbolRepository.saveAll(
                getSymbolsNasdaq().stream().map(TickerSymbolDao::new)
                        .collect(Collectors.toList())
        );
        this.tickerSymbolRepository.saveAll(
                getSymbolsNyse().stream().map(TickerSymbolDao::new)
                        .collect(Collectors.toList())
        );
    }

    // TODO: MAKE THIS AN UPDATE, NOT AN OVERWRITE/APPEND!
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
    // TODO: MAKE THIS AN UPDATE, NOT AN OVERWRITE/APPEND!
    /**
     * Download all price data for symbol.
     */
    public void downloadAllPriceDataForSymbol(String symbol) {
    }

    // TODO: Download all financial data for symbol.
    // TODO: MAKE THIS AN UPDATE, NOT AN OVERWRITE/APPEND!
    /**
     * Download all financial data for symbol.
     */
    public void downloadAllFinancialDataForSymbol(String symbol) {
    }
}
