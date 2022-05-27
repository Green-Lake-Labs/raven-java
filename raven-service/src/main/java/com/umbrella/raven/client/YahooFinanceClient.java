package com.umbrella.raven.client;

import com.umbrella.raven.model.exception.LookupException;
import com.umbrella.raven.model.profile.CompanyProfileResponse;
import com.umbrella.raven.model.symbol.TickerSymbolList;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class YahooFinanceClient {

    String BASE_URL = "https://stock-market-data.p.rapidapi.com";

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
}
