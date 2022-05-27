package com.umbrella.raven.controller;

import com.umbrella.raven.model.profile.CompanyProfile;
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
 * Controller for transacting with the market exchange APIs.
 */
@RestController
@RequestMapping("exchange")
@AllArgsConstructor
public class EntityController {


    final String EXCHANGE_OPENAPI_TAG = "Exchange API";


    final EntityService entityService;


    /**
     * Fetch all symbols in the database.
     */
    @Operation(summary = "Fetch all symbols in the database.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getSymbols/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TickerSymbolDao> fetchSymbolsAll() {
        return this.entityService.getSymbolsAll();
    }

    /**
     * Fetch a single company's profile info.
     */
    @Operation(summary = "Fetch a single company's profile info.",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(value = "/getProfileInfo/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyProfile fetchSymbolsAll(@PathVariable String symbol) {
        return this.entityService.getProfileInfo(symbol.toUpperCase());
    }

}
