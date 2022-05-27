package com.umbrella.raven.controller;

import com.umbrella.raven.model.CompanyProfile;
import com.umbrella.raven.model.symbol.TickerSymbolDao;
import com.umbrella.raven.service.ExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller for transacting with the market exchange APIs.
 */
@RestController
@RequestMapping("exchange")
@AllArgsConstructor
public class ExchangeController {


    final String EXCHANGE_OPENAPI_TAG = "Exchange API";


    final ExchangeService exchangeService;


    /**
     * Fetch all companies on the NYSE, NASDAQ, & AMEX.
     */
    @Operation(summary = "Fetch all companies on the NASDAQ & NYSE.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TickerSymbolDao> fetchSymbolsAll() {
        return this.exchangeService.getSymbolsAll();
    }

//    /**
//     * Fetch all companies on the NASDAQ.
//     */
//    @Operation(summary = "Fetch all companies on the NASDAQ.",
//            tags = EXCHANGE_OPENAPI_TAG)
//    @GetMapping(value = "/getSymbols/nasdaq",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CompanyProfile> fetchSymbolsNasdaq() {
//        return this.exchangeService.getSymbolsNasdaq();
//    }
//
//    /**
//     * Fetch all companies on the NYSE.
//     */
//    @Operation(summary = "Fetch all companies on the NYSE.",
//            tags = EXCHANGE_OPENAPI_TAG)
//    @GetMapping(value = "/getSymbols/nyse",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<CompanyProfile> fetchSymbolsNyse() {
//        return this.exchangeService.getSymbolsNyse();
//    }

//    /**
//     * Fetch a single company's profile.
//     */
//    @Operation(summary = "Fetch a single company's profile.",
//            tags = EXCHANGE_OPENAPI_TAG)
//    @GetMapping(value = "/getSymbol/{symbol}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public CompanyProfile fetchSymbolsAll(@PathVariable String symbol) {
//        return this.exchangeService.getSymbol(symbol);
//    }

}
