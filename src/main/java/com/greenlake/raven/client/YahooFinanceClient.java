package com.greenlake.raven.client;

import com.greenlake.raven.model.exception.LookupException;
import com.greenlake.raven.model.price.PriceDataResponse;
import com.greenlake.raven.model.profile.CompanyProfileResponse;
import com.greenlake.raven.model.symbol.TickerSymbolList;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class YahooFinanceClient {

    String BASE_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com/auto-complete";

    RestTemplate restTemplate;
    HttpHeaders headers;
    MultiValueMap<String, String> params;

    public YahooFinanceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.headers = new HttpHeaders() {{
            add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            add("X-RapidAPI-Host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
            add("X-RapidAPI-Key", System.getenv("X_RAPIDAPI_KEY"));
        }};
        this.params = new LinkedMultiValueMap<>();
    }

    public TickerSymbolList getTickerSymbols(String exchange) throws LookupException {
        if (exchange.equals("nasdaq") || exchange.equals("nyse")) {
            String url = BASE_URL + "/market/exchange/" + exchange;
            String uriTemplate = UriComponentsBuilder.fromHttpUrl(url)
                    .encode()
                    .toUriString();
            HttpEntity<?> requestEntity = new HttpEntity<>(this.headers);
            ResponseEntity<TickerSymbolList> responseEntity = restTemplate
                    .exchange(uriTemplate, HttpMethod.GET, requestEntity, TickerSymbolList.class);
            return responseEntity.getBody();
        } else {
            throw new LookupException("Exchange entered is invalid: \"" + exchange + "\". Must be \"nasdaq\" or \"nyse\".");
        }
    }

    public CompanyProfileResponse getProfileInfo(String symbol) {
        String url = BASE_URL + "/stock/company-info";
        String uriTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(new LinkedMultiValueMap<>() {{
                    add("ticker_symbol", symbol);
                }})
                .encode()
                .toUriString();
        HttpEntity<?> requestEntity = new HttpEntity<>(this.headers);
        ResponseEntity<CompanyProfileResponse> responseEntity = restTemplate
                .exchange(uriTemplate, HttpMethod.GET, requestEntity, CompanyProfileResponse.class);
        return responseEntity.getBody();
    }

    public PriceDataResponse getPriceData(String symbol, int years) {
        String url = BASE_URL + "/yfinance/historical-prices";
        String uriTemplate = UriComponentsBuilder.fromHttpUrl(url)
                .queryParams(new LinkedMultiValueMap<>() {{
                    add("ticker_symbol", symbol);
                    add("years", String.valueOf(years));
                }})
                .encode()
                .toUriString();
        HttpEntity<?> requestEntity = new HttpEntity<>(this.headers);
        ResponseEntity<PriceDataResponse> responseEntity = restTemplate
                .exchange(uriTemplate, HttpMethod.GET, requestEntity, PriceDataResponse.class);
        return responseEntity.getBody();
    }
}
