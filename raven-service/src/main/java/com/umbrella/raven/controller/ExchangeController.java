package com.umbrella.raven.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller for transacting with the market exchange APIs.
 */
@RestController
@RequestMapping("exchange")
public class ExchangeController {


    final String EXCHANGE_OPENAPI_TAG = "Exchange API";


    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }

    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = EXCHANGE_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }
}
