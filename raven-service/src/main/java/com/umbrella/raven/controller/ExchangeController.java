package com.umbrella.raven.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for transacting with the market exchange APIs.
 */
@RestController
@RequestMapping("exchange")
public class ExchangeController {


    final String EXCHANGE_OPENAPI_TAG = "Exchange API";


    /**
     * Fetch all companies on the NYSE, NASDAQ, & AMEX.
     */
    @Operation(summary = "Fetch all companies on the NYSE, NASDAQ, & AMEX.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getAllSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchAllSymbols() {
        return ""; // TODO: Fetch all companies on the NYSE, NASDAQ, & AMEX.
    }

    /**
     * Fetch all companies on the NYSE.
     */
    @Operation(summary = "Fetch all companies on the NYSE.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getAllSymbols/nyse",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchAllSymbolsNyse() {
        return ""; // TODO: Fetch all companies on the NYSE.
    }

    /**
     * Fetch all companies on the NASDAQ.
     */
    @Operation(summary = "Fetch all companies on the NASDAQ.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getAllSymbols/nasdaq",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchAllSymbolsNasdaq() {
        return ""; // TODO: Fetch all companies on the NASDAQ.
    }

    /**
     * Fetch all companies on the AMEX.
     */
    @Operation(summary = "Fetch all companies on the AMEX.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getAllSymbols/amex",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchAllSymbolsAmex() {
        return ""; // TODO: Fetch all companies on the AMEX.
    }

}
