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
     * Write all ticker symbols from the NASDAQ to the DB.
     */
    @Operation(summary = "Write all companies on the NASDAQ to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/nasdaq",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsNasdaq() throws LookupException {
        this.databaseService.writeSymbolsNasdaq();
        return "Writing all symbols from NASDAQ to the database. This will overwrite the existing tables of symbols.";
    }

    /**
     * Write all ticker symbols from the NYSE to the DB.
     */
    @Operation(summary = "Write all companies on the NYSE to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/nyse",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsNyse() throws LookupException {
        this.databaseService.writeSymbolsNyse();
        return "Writing all symbols from NYSE to the database. This will overwrite the existing tables of symbols.";
    }

    /**
     * Write all ticker symbols from the NASDAQ & NYSE to the DB.
     */
    @Operation(summary = "Write all companies on the NYSE & NASDAQ to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeSymbolsAll() throws LookupException {
        this.databaseService.writeSymbolsAll();
        return "Writing all symbols to the database. This will overwrite the existing tables of symbols.";
    }

    /**
     * Write profile info for a certain symbol to the database.
     */
    @Operation(summary = "Write profile info for a certain symbol to the database.",
            tags = DATABASE_OPENAPI_TAG)
    @GetMapping(value = "/writeProfileInfo/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String writeProfileInfo(@PathVariable String symbol) {
        this.databaseService.writeProfileInfo(symbol.toUpperCase());
        return "Profile info for symbol: " + symbol.toUpperCase() + " written to database.";
    }
}
