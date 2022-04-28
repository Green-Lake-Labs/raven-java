package com.umbrella.raven.controller;

import com.umbrella.raven.model.analysis.AnalysisFocusedAlgorithmConfig;
import com.umbrella.raven.model.analysis.AnalysisMainAlgorithmConfig;
import com.umbrella.raven.service.AnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for running deep analysis on the valuation data in the database.
 */
@RestController
@RequestMapping("analysis")
@AllArgsConstructor
public class AnalysisController {


    final String ANALYSIS_OPENAPI_TAG = "Analysis API";


    final AnalysisService analysisService;


    /**
     * Run the main post-valuation analysis algorithm.
     */
    @Operation(summary = "Run the main post-valuation analysis algorithm.",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(value = "/main/run",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runAnalysisAlgorithm() {
        this.analysisService.runAnalysisAlgorithm();
        return "Launching post-valuation analysis algorithm, which runs on all symbols. This may take a while...";
    }

    /**
     * Modify the main post-valuation analysis algorithm.
     */
    @Operation(summary = "Modify the main post-valuation analysis algorithm.",
            tags = ANALYSIS_OPENAPI_TAG)
    @PostMapping(value = "/main/modify",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String modifyAnalysisAlgorithm(@RequestBody AnalysisMainAlgorithmConfig config) {
        this.analysisService.modifyAnalysisAlgorithm(config);
        return "Successfully modified the main post-valuation analysis algorithm.";
    }

    /**
     * Run the focused post-valuation analysis algorithm on a specific equity.
     */
    @Operation(summary = "Run the focused post-valuation analysis algorithm on a specific equity.",
            tags = ANALYSIS_OPENAPI_TAG)
    @GetMapping(value = "/focused/run/{symbol}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runFocusedAlgorithm(@PathVariable String symbol) {
        this.analysisService.runFocusedAlgorithm(symbol);
        return "Launching post-valuation analysis algorithm on " + symbol + ". This may take a while...";
    }

    /**
     * Modify the focused post-valuation analysis algorithm.
     */
    @Operation(summary = "Modify the focused post-valuation analysis algorithm.",
            tags = ANALYSIS_OPENAPI_TAG)
    @PostMapping(value = "/focused/modify",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String runFocusedAlgorithm(@RequestBody AnalysisFocusedAlgorithmConfig config) {
        this.analysisService.modifyFocusedAlgorithm(config);
        return "Successfully modified the focused post-valuation analysis algorithm.";
    }

}
