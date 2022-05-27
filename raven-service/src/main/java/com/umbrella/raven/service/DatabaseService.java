package com.umbrella.raven.service;

import com.umbrella.raven.client.YahooFinanceClient;
import com.umbrella.raven.model.profile.CompanyProfile;
import com.umbrella.raven.model.profile.CompanyProfileDao;
import com.umbrella.raven.model.profile.CompanyProfileDaoRepository;
import com.umbrella.raven.model.symbol.TickerSymbol;
import com.umbrella.raven.model.symbol.TickerSymbolDao;
import com.umbrella.raven.model.exception.LookupException;
import com.umbrella.raven.model.symbol.TickerSymbolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * Update the database with all tickers from the NASDAQ & NYSE (Add new & remove expired).
     */
    public void writeSymbolsAll() throws LookupException {
        List<String> symbolsClient = getSymbolsNasdaq();
        symbolsClient.addAll(getSymbolsNyse());
        List<TickerSymbolDao> symbolsDatabase = this.tickerSymbolRepository.findAll();
        List<TickerSymbolDao> symbolsNew = new ArrayList<>();
        List<TickerSymbolDao> symbolsExpired = new ArrayList<>();
        for (String symbol: symbolsClient) {
            boolean exists = false;
            for (TickerSymbolDao symbolDao: symbolsDatabase) {
                if (symbolDao.getSymbol().equalsIgnoreCase(symbol)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                symbolsNew.add(new TickerSymbolDao(symbol));
            }
        }
        this.tickerSymbolRepository.saveAll(symbolsNew);
        for (TickerSymbolDao symbolDao: symbolsDatabase) {
            boolean exists = false;
            for (String symbol: symbolsClient) {
                if (symbolDao.getSymbol().equalsIgnoreCase(symbol)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                symbolsExpired.add(symbolDao);
            }
        }
        this.tickerSymbolRepository.deleteAll(symbolsExpired);
    }

    // TODO: MAKE THIS AN UPDATE, NOT AN OVERWRITE/APPEND!
    /**
     * Download company profile info for a certain symbol.
     */
    public boolean writeProfileInfo(String symbol) {
        try {
            this.companyProfileDaoRepository
                    .findAll()
                    .stream().filter(p -> p.getSymbol().equalsIgnoreCase(symbol))
                    .collect(Collectors.toList()).get(0);
            return false;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            this.companyProfileDaoRepository.save(
                    new CompanyProfileDao(
                            this.tickerSymbolRepository.findBySymbol(symbol),
                            yahooFinanceClient.getProfileInfo(symbol)
                    )
            );
            return true;
        }
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
