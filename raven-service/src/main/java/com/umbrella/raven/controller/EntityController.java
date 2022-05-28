package com.umbrella.raven.controller;

import com.umbrella.raven.model.financial.balancesheet.BalanceSheetData;
import com.umbrella.raven.model.financial.financial.FinancialData;
import com.umbrella.raven.model.financial.income.IncomeData;
import com.umbrella.raven.model.price.PriceData;
import com.umbrella.raven.model.profile.CompanyProfile;
import com.umbrella.raven.model.symbol.TickerSymbol;
import com.umbrella.raven.model.symbol.TickerSymbolDao;
import com.umbrella.raven.service.EntityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Controller for querying basic data on entities in the database.
 */
@RestController
@RequestMapping("entity")
@AllArgsConstructor
public class EntityController {

    final String ENTITY_OPENAPI_TAG = "Entity API";

    final EntityService entityService;

    /**
     * Fetch all symbols in the database.
     */
    @Operation(summary = "Fetch all symbols in the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TickerSymbolDao> fetchSymbolsAll() {
        return this.entityService.getSymbolsAll();
    }

    /**
     * Fetch a single company's symbol from the database.
     */
    @Operation(summary = "Fetch a single company's symbol from the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getSymbol/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TickerSymbol fetchSymbol(@PathVariable String symbol) {
        return this.entityService.getSymbol(symbol.toUpperCase());
    }

    /**
     * Fetch a single company's profile info from the database.
     */
    @Operation(summary = "Fetch a single company's profile info from the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getProfileInfo/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyProfile fetchProfileInfo(@PathVariable String symbol) {
        return this.entityService.getProfileInfo(symbol.toUpperCase());
    }

    /**
     * Fetch a single company's price data from the database.
     */
    @Operation(summary = "Fetch a single company's price data from the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getPriceData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceData> fetchPriceData(@PathVariable String symbol) {
        return this.entityService.getPriceData(symbol.toUpperCase());
    }

    /**
     * Fetch a single company's balance sheet data from the database.
     */
    @Operation(summary = "Fetch a single company's balance sheet data from the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getBalanceSheetData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BalanceSheetData> fetchBalanceSheetData(@PathVariable String symbol) {
        return this.entityService.getBalanceSheetData(symbol.toUpperCase());
    }

    /**
     * Fetch a single company's income statement data from the database.
     */
    @Operation(summary = "Fetch a single company's income statement data from the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getIncomeData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IncomeData> fetchIncomeData(@PathVariable String symbol) {
        return this.entityService.getIncomeData(symbol.toUpperCase());
    }

    /**
     * Fetch a single company's cash flow statement data from the database.
     */
    @Operation(summary = "Fetch a single company's cash flow statement data from the database.",
            tags = ENTITY_OPENAPI_TAG)
    @GetMapping(value = "/getCashFlowData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FinancialData> fetchCashFlowData(@PathVariable String symbol) {
        return this.entityService.getCashFlowData(symbol.toUpperCase());
    }

}
