package com.umbrella.raven.client;

import com.umbrella.raven.model.exchange.CompanyProfile;
import com.umbrella.raven.model.exchange.TickerSymbolList;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Component
public class YahooFinanceClient {

    RestTemplate restTemplate;
    HttpHeaders headers;
    MultiValueMap<String, String> params;

    public YahooFinanceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = new HttpHeaders() {{
            add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            add("X-RapidAPI-Host", "stock-market-data.p.rapidapi.com");
            add("X-RapidAPI-Key", System.getenv("X_RAPIDAPI_KEY"));
        }};
        this.params = new LinkedMultiValueMap<>();
    }

    public CompanyProfile getCompanyProfile(String tickerSymbol) {
        String url = "https://stock-market-data.p.rapidapi.com/stock/company-info";

        MultiValueMap<String, String> getCompanyProfileParams = this.params;
        getCompanyProfileParams.add("ticker_symbol", tickerSymbol);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(getCompanyProfileParams, this.headers);
        ResponseEntity<CompanyProfile> responseEntity = restTemplate
                .exchange(url, HttpMethod.GET, requestEntity, CompanyProfile.class);
        return responseEntity.getBody();
    }

    public List<CompanyProfile> getCompanyProfileList(List<String> tickerSymbolsList) {
        try {
            List<CompanyProfile> allTickerSymbolsNasdaq = new ArrayList<>();
            for (String tickerSymbolString : tickerSymbolsList) {
                allTickerSymbolsNasdaq.add(
                        getCompanyProfile(tickerSymbolString)
                );
            }
            return allTickerSymbolsNasdaq;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    public List<CompanyProfile> getAllTickerSymbolsNasdaq() {
        String url = "https://stock-market-data.p.rapidapi.com/market/exchange/nasdaq";

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(this.params, this.headers);
        ResponseEntity<TickerSymbolList> responseEntity = restTemplate
                .exchange(url, HttpMethod.GET, requestEntity, TickerSymbolList.class);
        return getCompanyProfileList(responseEntity.getBody().getTickerSymbolList());
    }

    public List<CompanyProfile> getAllTickerSymbolsNyse() {
        String url = "https://stock-market-data.p.rapidapi.com/market/exchange/nyse";

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(this.params, this.headers);
        ResponseEntity<TickerSymbolList> responseEntity = restTemplate
                .exchange(url, HttpMethod.GET, requestEntity, TickerSymbolList.class);
        return getCompanyProfileList(responseEntity.getBody().getTickerSymbolList());
    }

    public List<CompanyProfile> getAllTickerSymbols() {
        List<CompanyProfile> allTickerSymbols = getAllTickerSymbolsNasdaq();
        allTickerSymbols.addAll(getAllTickerSymbolsNyse());
        return allTickerSymbols;
    }

    public CompanyProfile getSymbol(String symbol) {
        return getCompanyProfile(symbol);
    }

}
