package com.greenlake.raven.formula;

import com.greenlake.raven.model.financial.balancesheet.BalanceSheetData;
import com.greenlake.raven.model.financial.cashflow.CashFlowData;
import com.greenlake.raven.model.financial.earnings.EarningsData;
import com.greenlake.raven.model.financial.income.IncomeData;
import com.greenlake.raven.model.profile.CompanyProfile;
import com.greenlake.raven.model.valuation.ValuationResult;
import com.greenlake.raven.model.valuation.BetaValuationResultImpl;
import com.greenlake.raven.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BetaValuationFormula implements ValuationFormula {

    @Autowired
    EntityService entityService;

    public ValuationResult getEquityValuation(String symbol) {

        CompanyProfile profile = entityService.getProfileInfo(symbol);
        List<BalanceSheetData> balanceSheetDataList = entityService.getBalanceSheetData(symbol);
        List<CashFlowData> cashFlowDataList = entityService.getCashFlowData(symbol);
        List<EarningsData> earningsDataList = entityService.getEarningsData(symbol);
        List<IncomeData> incomeDataList = entityService.getIncomeData(symbol);

        int currentPrice = 5;
        int currentValuation = 3;
        int timestamp = 20001515;

        return new BetaValuationResultImpl(currentPrice, currentValuation, timestamp);
    }
}
