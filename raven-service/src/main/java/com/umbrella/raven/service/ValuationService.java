package com.umbrella.raven.service;

import com.umbrella.raven.model.valuation.ValuationCurrentAlgorithmConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for driving the Valuation Client.
 */
@Service
@AllArgsConstructor
public class ValuationService {


    // TODO: Run the current valuation algorithm on all equities in the database.
    /**
     * Run the current valuation algorithm on all equities in the database.
     */
    public void runValuationCurrentAllSymbols() {
    }

    // TODO: Run the current valuation algorithm on a specific equity in the database.
    /**
     * Run the current valuation algorithm on a specific equity in the database.
     */
    public void runValuationCurrentForSymbol(String symbol) {
    }

    // TODO: Modify the current valuation algorithm.
    /**
     * Modify the current valuation algorithm.
     */
    public void modifyValuationCurrent(ValuationCurrentAlgorithmConfig config) {
    }


}
