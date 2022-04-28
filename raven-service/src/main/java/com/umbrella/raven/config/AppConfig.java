package com.umbrella.raven.config;

import com.umbrella.raven.client.exchange.ExchangeClient;
import com.umbrella.raven.client.exchange.PolygonClient;
import com.umbrella.raven.client.valuation.PolygonValuationClient;
import com.umbrella.raven.client.valuation.ValuationClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ExchangeClient exchangeClient() {
        return new PolygonClient();
    }

    @Bean
    public ValuationClient valuationClient() {
        return new PolygonValuationClient();
    }

}
