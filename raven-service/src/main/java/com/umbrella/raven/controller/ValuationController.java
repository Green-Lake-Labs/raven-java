package com.umbrella.raven.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for conducting & modifying valuation calculations.
 */
@RestController
@RequestMapping("valuation")
public class ValuationController {


    final String VALUATION_OPENAPI_TAG = "Valuation API";


    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = VALUATION_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = VALUATION_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = VALUATION_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }
}
