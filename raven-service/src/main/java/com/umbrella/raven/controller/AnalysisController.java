package com.umbrella.raven.controller;

import com.umbrella.raven.model.analysis.AnalysisFocusedAlgorithmConfig;
import com.umbrella.raven.model.analysis.AnalysisMainAlgorithmConfig;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for running deep analysis on the valuation data in the database.
 */
@RestController
@RequestMapping("analysis")
public class AnalysisController {


    final String ANALYSIS_OPENAPI_TAG = "Analysis API";


    /**
     * Run the main post-valuation analysis algorithm.
     */
    @Operation(summary = "Run the main post-valuation analysis algorithm.",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(value = "/main/run",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runAnalysisAlgorithm() {
        return ""; // TODO: Run the main post-valuation analysis algorithm.
    }

    /**
     * Modify the main post-valuation analysis algorithm.
     */
    @Operation(summary = "Modify the main post-valuation analysis algorithm.",
            tags = ANALYSIS_OPENAPI_TAG)
    @PostMapping(value = "/main/modify",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String modifyAnalysisAlgorithm(@RequestBody AnalysisMainAlgorithmConfig config) {
        return ""; // TODO: Modify the main post-valuation analysis algorithm.
    }

    /**
     * Run the focused post-valuation analysis algorithm on a specific equity.
     */
    @Operation(summary = "Run the focused post-valuation analysis algorithm on a specific equity.",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(value = "/focused/run/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runFocusedAlgorithm(@PathVariable String symbol) {
        return ""; // TODO: Run the focused post-valuation analysis algorithm on a specific equity.
    }

    /**
     * Modify the focused post-valuation analysis algorithm.
     */
    @Operation(summary = "Modify the focused post-valuation analysis algorithm.",
            tags = ANALYSIS_OPENAPI_TAG)
    @PostMapping(value = "/focused/modify",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runFocusedAlgorithm(@RequestBody AnalysisFocusedAlgorithmConfig config) {
        return ""; // TODO: Modify the focused post-valuation analysis algorithm.
    }

}
