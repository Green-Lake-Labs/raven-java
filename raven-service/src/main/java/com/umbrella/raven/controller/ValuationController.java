package com.umbrella.raven.controller;

import com.umbrella.raven.service.ValuationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for conducting & modifying valuation calculations.
 */
@RestController
@RequestMapping("valuation")
@AllArgsConstructor
public class ValuationController {


    final String VALUATION_OPENAPI_TAG = "Valuation API";


    final ValuationService valuationService;


    /**
     * Run the current valuation algorithm on all equities in the database.
     */
    @Operation(summary = "Run the current valuation algorithm on all equities in the database.",
            tags = VALUATION_OPENAPI_TAG)
    @GetMapping(value = "/current/run",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runValuationCurrentAllSymbols() {
        this.valuationService.runValuationCurrentAllSymbols();
        return "Launching valuation on all symbols in the database. This may take a while...";
    }

}
