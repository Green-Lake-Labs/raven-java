package com.umbrella.raven.client.exchange;

import com.umbrella.raven.model.exchange.Symbol;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class PolygonClient implements ExchangeClient {


    final String POLYGON_BASE_URL = "https://api.polygon.io/v3/";

    @Autowired
    RestTemplate restTemplate;

    public List<Symbol> getAllSymbols() {
        return new ArrayList<>();
    }

    public List<Symbol> getAllSymbolsAmex() {
        return new ArrayList<>();
    }

    public List<Symbol> getAllSymbolsNasdaq() {
        return new ArrayList<>();
    }

    public List<Symbol> getAllSymbolsNyse() {
        return new ArrayList<>();
    }

}
