package com.greenlake.raven.model.price;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDataResponse {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HistoricalPriceRaw {
        @JsonProperty("Open")
        float open;
        @JsonProperty("High")
        float high;
        @JsonProperty("Low")
        float low;
        @JsonProperty("Close")
        float close;
        @JsonProperty("Adj Close")
        float adjClose;
        @JsonProperty("Volume")
        float volume;
        @JsonProperty("Date")
        LocalDate date;
    }
    @JsonProperty("historical prices")
    List<HistoricalPriceRaw> historicalPrices;
    String date;
    String status;
}
