package com.umbrella.raven.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for querying the database of valuation results.
 */
@RestController
@RequestMapping("query")
public class QueryController {


    final String QUERY_OPENAPI_TAG = "Query API";


    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = QUERY_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

}
