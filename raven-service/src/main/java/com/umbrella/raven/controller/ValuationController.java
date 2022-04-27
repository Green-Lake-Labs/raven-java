package com.umbrella.raven.controller;

import com.umbrella.raven.model.valuation.ValuationCurrentAlgorithmConfig;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for conducting & modifying valuation calculations.
 */
@RestController
@RequestMapping("valuation")
public class ValuationController {


    final String VALUATION_OPENAPI_TAG = "Valuation API";


    /**
     * Run the current valuation algorithm on all equities in the database.
     */
    @Operation(summary = "Run the current valuation algorithm on all equities in the database.",
            tags = VALUATION_OPENAPI_TAG)
    @GetMapping(value = "/current/run",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runValuationCurrentAllSymbols() {
        return ""; // TODO: Run the current valuation algorithm on all equities in the database.
    }

    /**
     * Run the current valuation algorithm on a specific equity in the database.
     */
    @Operation(summary = "Run the current valuation algorithm on a specific equity in the database.",
            tags = VALUATION_OPENAPI_TAG)
    @GetMapping(value = "/current/run/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runValuationCurrentForSymbol(@PathVariable String symbol) {
        return ""; // TODO: Run the current valuation algorithm on a specific equity in the database.
    }

    /**
     * Modify the current valuation algorithm.
     */
    @Operation(summary = "Modify the current valuation algorithm.",
            tags = VALUATION_OPENAPI_TAG)
    @PostMapping(value = "/current/modify",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String modifyValuationCurrent(@RequestBody ValuationCurrentAlgorithmConfig config) {
        return ""; // TODO: Modify the current valuation algorithm.
    }

}
