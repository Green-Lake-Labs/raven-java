package com.umbrella.raven.service;

import com.umbrella.raven.model.profile.CompanyProfile;
import com.umbrella.raven.model.profile.CompanyProfileDaoRepository;
import com.umbrella.raven.model.symbol.TickerSymbolDao;
import com.umbrella.raven.model.symbol.TickerSymbolRepository;
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
    TickerSymbolRepository tickerSymbolRepository;
    @Autowired
    CompanyProfileDaoRepository companyProfileDaoRepository;

    public List<TickerSymbolDao> getSymbolsAll() {
        return this.tickerSymbolRepository.findAll();
    }

    public CompanyProfile getProfileInfo(String symbol) {
        return this.companyProfileDaoRepository.findAll()
                .stream()
                .filter(s -> s.getSymbol().equals(symbol))
                .map(CompanyProfile::new)
                .collect(Collectors.toList());
    }

}
