package com.umbrella.raven.service;

import com.umbrella.raven.client.YahooFinanceClient;
import com.umbrella.raven.model.exchange.CompanyProfile;
import com.umbrella.raven.model.exchange.CompanyProfileDao;
import com.umbrella.raven.model.exchange.CompanyProfileDaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for driving the Exchange Client.
 */
@Service
@AllArgsConstructor
public class ExchangeService {

    @Autowired
    CompanyProfileDaoRepository companyProfileDaoRepository;

    final YahooFinanceClient yahooFinanceClient;

    public List<CompanyProfile> getSymbolsAll() {
        return this.yahooFinanceClient.getAllTickerSymbols();
    }

    public List<CompanyProfile> getSymbolsNasdaq() {
        return this.yahooFinanceClient.getAllTickerSymbolsNasdaq();
    }

    public List<CompanyProfile> getSymbolsNyse() {
        return this.yahooFinanceClient.getAllTickerSymbolsNyse();
    }

    public void writeSymbolsAll() {
        this.companyProfileDaoRepository.saveAll(
                getSymbolsAll().stream().map(c -> new CompanyProfileDao(c))
                        .collect(Collectors.toList())
        );
    }

    public void writeSymbolsNasdaq() {
        this.companyProfileDaoRepository.saveAll(
                getSymbolsNasdaq().stream().map(c -> new CompanyProfileDao(c))
                        .collect(Collectors.toList())
        );
    }

    public void writeSymbolsNyse() {
        this.companyProfileDaoRepository.saveAll(
                getSymbolsNyse().stream().map(c -> new CompanyProfileDao(c))
                        .collect(Collectors.toList())
        );
    }

}
