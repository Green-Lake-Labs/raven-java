package com.umbrella.raven.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for running deep analysis on the valuation data in the database.
 */
@RestController
@RequestMapping("analysis")
public class AnalysisController {


    final String ANALYSIS_OPENAPI_TAG = "Analysis API";


    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }
}
