package com.greenlake.raven.service;

import com.greenlake.raven.model.financial.balancesheet.*;
import com.greenlake.raven.model.financial.cashflow.*;
import com.greenlake.raven.model.financial.earnings.*;
import com.greenlake.raven.model.financial.income.*;
import com.greenlake.raven.model.price.*;
import com.greenlake.raven.model.profile.*;
import com.greenlake.raven.model.symbol.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for driving the Exchange Client.
 */
@Service
@AllArgsConstructor
public class EntityService {

    @Autowired
    TickerSymbolRepository tickerSymbolRepository;
    @Autowired
    CompanyProfileDaoRepository companyProfileDaoRepository;
    @Autowired
    CompanyProfileQueryDaoRepository companyProfileQueryDaoRepository;
    @Autowired
    PriceDataDaoRepository priceDataDaoRepository;
    @Autowired
    PriceDataQueryDaoRepository priceDataQueryDaoRepository;
    @Autowired
    BalanceSheetDataDaoRepository balanceSheetDataDaoRepository;
    @Autowired
    BalanceSheetDataQueryDaoRepository balanceSheetDataQueryDaoRepository;
    @Autowired
    IncomeDataDaoRepository incomeDataDaoRepository;
    @Autowired
    IncomeDataQueryDaoRepository incomeDataQueryDaoRepository;
    @Autowired
    CashFlowDataDaoRepository cashFlowDataDaoRepository;
    @Autowired
    CashFlowDataQueryDaoRepository cashFlowDataQueryDaoRepository;
    @Autowired
    EarningsDataDaoRepository earningsDataDaoRepository;
    @Autowired
    EarningsDataQueryDaoRepository earningsDataQueryDaoRepository;

    /**
     * Fetch all symbols in the database.
     */
    public List<TickerSymbolDao> getSymbolsAll() {
        return this.tickerSymbolRepository.findAll();
    }

    /**
     * Fetch a single company's symbol from the database.
     */
    public TickerSymbol getSymbol(String symbol) {
        try {
            return new TickerSymbolImpl(
                    this.tickerSymbolRepository.findBySymbol(symbol)
            );
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return new TickerSymbolNotFound(symbol);
        }
    }

    /**
     * Fetch a single company's profile info from the database.
     */
    public CompanyProfile getProfileInfo(String symbol) {
        try {
            return new CompanyProfileImpl(
                    this.companyProfileQueryDaoRepository.findByTickerSymbolDaoSymbol(symbol)
            );
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return new CompanyProfileNotFound(symbol);
        }
    }

    /**
     * Fetch a single company's price data from the database.
     */
    public List<PriceData> getPriceData(String symbol) {
        try {
            return this.priceDataQueryDaoRepository.findAllByTickerSymbolDaoSymbol(symbol)
                    .stream().map(PriceDataImpl::new)
                    .collect(Collectors.toList());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return Collections.singletonList(new PriceDataNotFound(symbol));
        }
    }

    /**
     * Fetch a single company's balance sheet data from the database.
     */
    public List<BalanceSheetData> getBalanceSheetData(String symbol) {
        try {
            return this.balanceSheetDataQueryDaoRepository.findAllByTickerSymbolDaoSymbol(symbol)
                    .stream().map(m -> new BalanceSheetDataImpl())
                    .collect(Collectors.toList());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return Collections.singletonList(new BalanceSheetDataNotFound(symbol));
        }
    }

    /**
     * Fetch a single company's income statement data from the database.
     */
    public List<IncomeData> getIncomeData(String symbol) {
        try {
            return this.incomeDataQueryDaoRepository.findAllByTickerSymbolDaoSymbol(symbol)
                    .stream().map(m -> new IncomeDataImpl())
                    .collect(Collectors.toList());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return Collections.singletonList(new IncomeDataNotFound(symbol));
        }
    }

    /**
     * Fetch a single company's cash flow statement data from the database.
     */
    public List<CashFlowData> getCashFlowData(String symbol) {
        try {
            return this.cashFlowDataQueryDaoRepository.findAllByTickerSymbolDaoSymbol(symbol)
                    .stream().map(m -> new CashFlowDataImpl())
                    .collect(Collectors.toList());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return Collections.singletonList(new CashFlowDataNotFound(symbol));
        }
    }

    /**
     * Fetch a single company's earnings data from the database.
     */
    public List<EarningsData> getEarningsData(String symbol) {
        try {
            return this.earningsDataQueryDaoRepository.findAllByTickerSymbolDaoSymbol(symbol)
                    .stream().map(m -> new EarningsDataImpl())
                    .collect(Collectors.toList());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return Collections.singletonList(new EarningsDataNotFound(symbol));
        }
    }

}
