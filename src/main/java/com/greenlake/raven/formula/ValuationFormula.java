package com.greenlake.raven.formula;

import com.greenlake.raven.model.valuation.ValuationResult;

public interface ValuationFormula {
    ValuationResult getEquityValuation(String symbol);
}
