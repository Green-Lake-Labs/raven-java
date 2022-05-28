package com.umbrella.raven.service;

import com.umbrella.raven.client.YahooFinanceClient;
import com.umbrella.raven.model.price.PriceDataDao;
import com.umbrella.raven.model.price.PriceDataDaoRepository;
import com.umbrella.raven.model.profile.CompanyProfileDao;
import com.umbrella.raven.model.profile.CompanyProfileDaoRepository;
import com.umbrella.raven.model.symbol.TickerSymbolDao;
import com.umbrella.raven.model.exception.LookupException;
import com.umbrella.raven.model.symbol.TickerSymbolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
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
    @Autowired
    PriceDataDaoRepository priceDataDaoRepository;

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

    /**
     * Download all price data for symbol.
     */
    public void writePriceData(String symbol) {
        TickerSymbolDao tickerSymbol = this.tickerSymbolRepository.findBySymbol(symbol);
        LocalDate latestDate = LocalDate.of(1970, 1, 1);
        PriceDataDao latestPriceDataDao = this.priceDataDaoRepository.findFirstBySymbolOrderByDateDesc(symbol);
        if (latestPriceDataDao != null) latestDate = latestPriceDataDao.getDate();
        LocalDate currentDate = LocalDate.now();
        int yearsToFetch = Period.between(latestDate, currentDate).getYears();
        if (yearsToFetch == 0) yearsToFetch = 1;
        LocalDate finalLatestDate = latestDate;
        this.priceDataDaoRepository.saveAll(
                yahooFinanceClient.getPriceData(symbol, yearsToFetch)
                        .getHistoricalPrices()
                        .stream()
                        .filter(p -> p.getDate().isAfter(finalLatestDate))
                        .map(p -> new PriceDataDao(tickerSymbol, p))
                        .collect(Collectors.toList())
        );
    }

    /**
     * Download all balance sheet data for symbol.
     */
    public void writeBalanceSheetData(String symbol) {
    }

    /**
     * Download all income statement data for symbol.
     */
    public void writeIncomeData(String symbol) {
    }

    /**
     * Download all cash flow statement data for symbol.
     */
    public void writeCashFlowData(String symbol) {
    }
}
