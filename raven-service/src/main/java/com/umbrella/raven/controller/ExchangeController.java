package com.umbrella.raven.controller;

import com.umbrella.raven.model.exchange.Symbol;
import com.umbrella.raven.service.ExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Operation(summary = "Fetch all companies on the NYSE, NASDAQ, & AMEX.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Symbol> fetchSymbolsAll() {
        return this.exchangeService.getSymbolsAll();
    }

    /**
     * Write all companies on the NYSE, NASDAQ, & AMEX to the database.
     */
    @Operation(summary = "Write all companies on the NYSE, NASDAQ, & AMEX to the database.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsAll() {
        this.exchangeService.writeSymbolsAll();
        return "Writing all symbols to the database. This will overwrite the existing tables of symbols.";
    }

    /**
     * Fetch all companies on the AMEX.
     */
    @Operation(summary = "Fetch all companies on the AMEX.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/amex",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Symbol> fetchSymbolsAmex() {
        return this.exchangeService.getSymbolsAmex();
    }

    /**
     * Write all companies on the AMEX to the database.
     */
    @Operation(summary = "Write all companies on the AMEX to the database.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/amex",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsAmex() {
        this.exchangeService.writeSymbolsAmex();
        return "Writing all symbols from AMEX to the database. This will overwrite the existing tables of symbols.";
    }

    /**
     * Fetch all companies on the NASDAQ.
     */
    @Operation(summary = "Fetch all companies on the NASDAQ.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/nasdaq",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Symbol> fetchSymbolsNasdaq() {
        return this.exchangeService.getSymbolsNasdaq();
    }

    /**
     * Write all companies on the NASDAQ to the database.
     */
    @Operation(summary = "Write all companies on the NASDAQ to the database.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/nasdaq",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsNasdaq() {
        this.exchangeService.writeSymbolsNasdaq();
        return "Writing all symbols from NASDAQ to the database. This will overwrite the existing tables of symbols.";
    }

    /**
     * Fetch all companies on the NYSE.
     */
    @Operation(summary = "Fetch all companies on the NYSE.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/nyse",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Symbol> fetchSymbolsNyse() {
        return this.exchangeService.getSymbolsNyse();
    }

    /**
     * Write all companies on the NYSE to the database.
     */
    @Operation(summary = "Write all companies on the NYSE to the database.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/nyse",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsNyse() {
        this.exchangeService.writeSymbolsNyse();
        return "Writing all symbols from NYSE to the database. This will overwrite the existing tables of symbols.";
    }

}
