package com.umbrella.raven.controller;

import com.umbrella.raven.model.exception.LookupException;
import com.umbrella.raven.service.DatabaseService;
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
}
