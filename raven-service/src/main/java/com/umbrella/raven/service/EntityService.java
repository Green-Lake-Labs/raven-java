package com.umbrella.raven.service;

import com.umbrella.raven.model.profile.CompanyProfile;
import com.umbrella.raven.model.profile.CompanyProfileDaoRepository;
import com.umbrella.raven.model.profile.CompanyProfileQueryDaoRepository;
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

    public CompanyProfile getProfileInfo(String symbol) {
        return this.companyProfileQueryDaoRepository.findAll()
                .stream()
                .filter(s -> s.getTickerSymbolDao().getSymbol().equals(symbol))
                .map(CompanyProfile::new)
                .collect(Collectors.toList()).get(0);
    }

}
