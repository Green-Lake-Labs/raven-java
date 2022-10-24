package com.greenlake.raven.model.valuation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BetaValuationResultImpl implements ValuationResult {

    int currentPrice;
    int currentValuation;
    int timestamp;
}
