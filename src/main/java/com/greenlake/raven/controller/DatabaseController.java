package com.greenlake.raven.controller;

import com.greenlake.raven.service.DatabaseService;
import com.greenlake.raven.model.exception.LookupException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for hydrating the database.
 */
@RestController
@RequestMapping("database")
@AllArgsConstructor
public class DatabaseController {

    final String DATABASE_OPENAPI_TAG = "Database API";

    final DatabaseService databaseService;


    /**
     * Update the database with all tickers from the NASDAQ & NYSE (Add new & remove expired).
     */
    @Operation(summary = "Update the database with all tickers from the NASDAQ & NYSE (Add new & remove expired).",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsAll() {
        try {
            this.databaseService.writeSymbolsAll();
            return "All symbols updated in the database.";
        } catch (LookupException e) {
            return "ERROR: Database update failed.";
        }
    }

    /**
     * Write profile info for a certain symbol to the database.
     */
    @Operation(summary = "Write profile info for a certain symbol to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeProfileInfo/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeProfileInfo(@PathVariable String symbol) {
        if (this.databaseService.writeProfileInfo(symbol.toUpperCase())) {
            return "Profile info for symbol: " + symbol.toUpperCase() + " written to database.";
        } else {
            return "WARN: Profile info for symbol: " + symbol.toUpperCase() + " already present in database.";
        }
    }

    /**
     * Write price data for a certain symbol to the database.
     */
    @Operation(summary = "Write price data for a certain symbol to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writePriceData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writePriceData(@PathVariable String symbol) {
        try {
            this.databaseService.writePriceData(symbol);
            return "Price data for symbol: " + symbol.toUpperCase() + " written to database.";
        } catch (Exception e) {
            return "ERROR: Database update failed.";
        }
    }

    /**
     * Write balance sheet data for a certain symbol to the database.
     */
    @Operation(summary = "Write balance sheet data for a certain symbol to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeBalanceSheetData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeBalanceSheetData(@PathVariable String symbol) {
        try {
            this.databaseService.writeBalanceSheetData(symbol);
            return "Balance sheet data for symbol: " + symbol.toUpperCase() + " written to database.";
        } catch (Exception e) {
            return "ERROR: Database update failed.";
        }
    }

    /**
     * Write income statement data for a certain symbol to the database.
     */
    @Operation(summary = "Write income statement data for a certain symbol to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeIncomeData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeIncomeData(@PathVariable String symbol) {
        try {
            this.databaseService.writeIncomeData(symbol);
            return "Income statement data for symbol: " + symbol.toUpperCase() + " written to database.";
        } catch (Exception e) {
            return "ERROR: Database update failed.";
        }
    }

    /**
     * Write cash flow statement data for a certain symbol to the database.
     */
    @Operation(summary = "Write cash flow statement data for a certain symbol to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeCashFlowData/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeCashFlowData(@PathVariable String symbol) {
        try {
            this.databaseService.writeCashFlowData(symbol);
            return "Cash flow statement data for symbol: " + symbol.toUpperCase() + " written to database.";
        } catch (Exception e) {
            return "ERROR: Database update failed.";
        }
    }
}
