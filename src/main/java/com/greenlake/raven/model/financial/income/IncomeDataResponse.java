package com.greenlake.raven.model.financial.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeDataResponse {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IncomeStatementRaw {
        String fiscalDateEnding;
        String reportedCurrency;
        String grossProfit;
        String totalRevenue;
        String costOfRevenue;
        String costofGoodsAndServicesSold;
        String operatingIncome;
        String sellingGeneralAndAdministrative;
        String researchAndDevelopment;
        String operatingExpenses;
        String investmentIncomeNet;
        String netInterestIncome;
        String interestIncome;
        String interestExpense;
        String nonInterestIncome;
        String otherNonOperatingIncome;
        String depreciation;
        String depreciationAndAmortization;
        String incomeBeforeTax;
        String incomeTaxExpense;
        String interestAndDebtExpense;
        String netIncomeFromContinuingOperations;
        String comprehensiveIncomeNetOfTax;
        String ebit;
        String ebitda;
        String netIncome;
    }
    String symbol;
    List<IncomeStatementRaw> annualReports;
    List<IncomeStatementRaw> quarterlyReports;
}
