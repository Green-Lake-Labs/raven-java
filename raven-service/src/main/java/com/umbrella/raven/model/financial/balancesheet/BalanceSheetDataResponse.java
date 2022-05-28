package com.umbrella.raven.model.financial.balancesheet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceSheetDataResponse {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EndDate {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MaxAge {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Cash {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Inventory {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NetReceivables {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NetTangibleAssets {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherCurrentAssets {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TotalCurrentAssets {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherAssets {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TotalAssets {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AccountsPayable {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShortLongTermDebt {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LongTermDebt {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShortTermInvestments {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LongTermInvestments {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PropertyPlantEquipment {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherCurrentLiabilities {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TotalCurrentLiabilities {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherLiabilities {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TotalLiabilities {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CommonStock {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreasuryStock {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RetainedEarnings {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OtherStockholderEquity {
        long raw;
        String fmt;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TotalStockholderEquity {
        long raw;
        String fmt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BalanceSheetRaw {
        @JsonProperty("endDate")
        EndDate endDate;
        @JsonProperty("maxAge")
        MaxAge maxAge;
        @JsonProperty("cash")
        Cash cash;
        @JsonProperty("inventory")
        Inventory inventory;
        @JsonProperty("netReceivables")
        NetReceivables netReceivables;
        @JsonProperty("netTangibleAssets")
        NetTangibleAssets netTangibleAssets;
        @JsonProperty("otherCurrentAssets")
        OtherCurrentAssets otherCurrentAssets;
        @JsonProperty("totalCurrentAssets")
        TotalCurrentAssets totalCurrentAssets;
        @JsonProperty("otherAssets")
        OtherAssets otherAssets;
        @JsonProperty("totalAssets")
        TotalAssets totalAssets;
        @JsonProperty("accountsPayable")
        AccountsPayable accountsPayable;
        @JsonProperty("shortLongTermDebt")
        ShortLongTermDebt shortLongTermDebt;
        @JsonProperty("longTermDebt")
        LongTermDebt longTermDebt;
        @JsonProperty("shortTermInvestments")
        ShortTermInvestments shortTermInvestments;
        @JsonProperty("longTermInvestments")
        LongTermInvestments longTermInvestments;
        @JsonProperty("propertyPlantEquipment")
        PropertyPlantEquipment propertyPlantEquipment;
        @JsonProperty("otherCurrentLiab")
        OtherCurrentLiabilities otherCurrentLiabilities;
        @JsonProperty("totalCurrentLiabilities")
        TotalCurrentLiabilities totalCurrentLiabilities;
        @JsonProperty("otherLiab")
        OtherLiabilities otherLiabilities;
        @JsonProperty("totalLiab")
        TotalLiabilities totalLiabilities;
        @JsonProperty("commonStock")
        CommonStock commonStock;
        @JsonProperty("treasuryStock")
        TreasuryStock treasuryStock;
        @JsonProperty("retainedEarnings")
        RetainedEarnings retainedEarnings;
        @JsonProperty("otherStockholderEquity")
        OtherStockholderEquity otherStockholderEquity;
        @JsonProperty("totalStockholderEquity")
        TotalStockholderEquity totalStockholderEquity;
    }
    @JsonProperty("quarterly_balance_sheets")
    List<BalanceSheetRaw> balanceSheets;
    String date;
    String status;
}
