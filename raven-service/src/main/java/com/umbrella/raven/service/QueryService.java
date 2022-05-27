package com.umbrella.raven.service;

import com.umbrella.raven.model.ValuationResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for querying the database post-valuation.
 */
@Service
public class QueryService {


    // TODO: Get the top 50 over-valued companies on the NYSE, NASDAQ, & AMEX (combined).
    /**
     * Get the top 50 over-valued companies on the NYSE, NASDAQ, & AMEX (combined).
     */
    public List<ValuationResult> getTopFiftyOverValuedAllExchanges() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 over-valued companies on the AMEX.
    /**
     * Get the top 50 over-valued companies on the AMEX.
     */
    public List<ValuationResult> getTopFiftyOverValuedAmex() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 over-valued companies on the NASDAQ.
    /**
     * Get the top 50 over-valued companies on the NASDAQ.
     */
    public List<ValuationResult> getTopFiftyOverValuedNasdaq() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 over-valued companies on the NYSE.
    /**
     * Get the top 50 over-valued companies on the NYSE.
     */
    public List<ValuationResult> getTopFiftyOverValuedNyse() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 under-valued companies on the NYSE, NASDAQ, & AMEX (combined).
    /**
     * Get the top 50 under-valued companies on the NYSE, NASDAQ, & AMEX (combined).
     */
    public List<ValuationResult> getTopFiftyUnderValuedAllExchanges() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 under-valued companies on the AMEX.
    /**
     * Get the top 50 under-valued companies on the AMEX.
     */
    public List<ValuationResult> getTopFiftyUnderValuedAmex() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 under-valued companies on the NASDAQ.
    /**
     * Get the top 50 under-valued companies on the NASDAQ.
     */
    public List<ValuationResult> getTopFiftyUnderValuedNasdaq() {
        return new ArrayList<>();
    }

    // TODO: Get the top 50 under-valued companies on the NYSE.
    /**
     * Get the top 50 under-valued companies on the NYSE.
     */
    public List<ValuationResult> getTopFiftyUnderValuedNyse() {
        return new ArrayList<>();
    }

}
