package com.umbrella.raven.service;

import com.umbrella.raven.model.profile.*;
import com.umbrella.raven.model.symbol.*;
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
public class EntityService {

    @Autowired
    TickerSymbolRepository tickerSymbolRepository;
    @Autowired
    CompanyProfileDaoRepository companyProfileDaoRepository;
    @Autowired
    CompanyProfileQueryDaoRepository companyProfileQueryDaoRepository;

    public List<TickerSymbolDao> getSymbolsAll() {
        return this.tickerSymbolRepository.findAll();
    }

    public TickerSymbol getSymbol(String symbol) {
        try {
            return this.tickerSymbolRepository.findAll()
                    .stream()
                    .filter(s -> s.getSymbol().equals(symbol))
                    .map(TickerSymbolImpl::new)
                    .collect(Collectors.toList()).get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return new TickerSymbolNotFound(symbol);
        }
    }

    public CompanyProfile getProfileInfo(String symbol) {
        try {
            return this.companyProfileQueryDaoRepository.findAll()
                    .stream()
                    .filter(s -> s.getTickerSymbolDao().getSymbol().equals(symbol))
                    .map(CompanyProfileImpl::new)
                    .collect(Collectors.toList()).get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return new CompanyProfileNotFound(symbol);
        }
    }

}
