package com.umbrella.raven.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Core Raven controller.
 */
@RestController
public class RavenController {


    final String RAVEN_OPENAPI_TAG = "Raven Core API";


    /**
     * Template.
     */
    @Operation(summary = "template",
            tags = RAVEN_OPENAPI_TAG)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String template() {
        return ""; // TODO: Template
    }
}
