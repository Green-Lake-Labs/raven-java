package com.umbrella.raven.formulae;

import com.umbrella.raven.model.ValuationResult;

public interface ValuationFormula {
    ValuationResult getEquityValuation(String symbol);
}
