package com.umbrella.raven.controller;

import com.umbrella.raven.model.valuation.ValuationResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Controller for querying the database of valuation results.
 */
@RestController
@RequestMapping("query")
public class QueryController {


    final String QUERY_OPENAPI_TAG = "Query API";


    /**
     * Get the top 50 over-valued companies on the NYSE, NASDAQ, & AMEX (combined).
     */
    @Operation(summary = "Get the top 50 over-valued companies on the NYSE, NASDAQ, & AMEX (combined).",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/overValued/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyOverValuedAllExchanges() {
        return new ArrayList<>(); // TODO: Get the top 50 over-valued companies on the NYSE, NASDAQ, & AMEX (combined).
    }

    /**
     * Get the top 50 over-valued companies on the NYSE.
     */
    @Operation(summary = "Get the top 50 over-valued companies on the NYSE.",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/overValued/nyse",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyOverValuedNyse() {
        return new ArrayList<>(); // TODO: Get the top 50 over-valued companies on the NYSE.
    }

    /**
     * Get the top 50 over-valued companies on the NASDAQ.
     */
    @Operation(summary = "Get the top 50 over-valued companies on the NASDAQ.",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/overValued/nasdaq",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyOverValuedNasdaq() {
        return new ArrayList<>(); // TODO: Get the top 50 over-valued companies on the NASDAQ.
    }

    /**
     * Get the top 50 over-valued companies on the AMEX.
     */
    @Operation(summary = "Get the top 50 over-valued companies on the AMEX.",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/overValued/amex",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyOverValuedAmex() {
        return new ArrayList<>(); // TODO: Get the top 50 over-valued companies on the AMEX.
    }

    /**
     * Get the top 50 under-valued companies on the NYSE, NASDAQ, & AMEX (combined).
     */
    @Operation(summary = "Get the top 50 under-valued companies on the NYSE, NASDAQ, & AMEX (combined).",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/underValued/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyUnderValuedAllExchanges() {
        return new ArrayList<>(); // TODO: Get the top 50 under-valued companies on the NYSE, NASDAQ, & AMEX (combined).
    }

    /**
     * Get the top 50 under-valued companies on the NYSE.
     */
    @Operation(summary = "Get the top 50 under-valued companies on the NYSE.",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/underValued/nyse",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyUnderValuedNyse() {
        return new ArrayList<>(); // TODO: Get the top 50 under-valued companies on the NYSE.
    }

    /**
     * Get the top 50 under-valued companies on the NASDAQ.
     */
    @Operation(summary = "Get the top 50 under-valued companies on the NASDAQ.",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/underValued/nasdaq",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyUnderValuedNasdaq() {
        return new ArrayList<>(); // TODO: Get the top 50 under-valued companies on the NASDAQ.
    }

    /**
     * Get the top 50 under-valued companies on the AMEX.
     */
    @Operation(summary = "Get the top 50 under-valued companies on the AMEX.",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(value = "/underValued/amex",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ValuationResult> getTopFiftyUnderValuedAmex() {
        return new ArrayList<>(); // TODO: Get the top 50 under-valued companies on the AMEX.
    }

}
