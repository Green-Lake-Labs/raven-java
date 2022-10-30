package com.greenlake.raven.model.price;

import lombok.Data;

@Data
public class PriceDataNotFound implements PriceData {
    String message;
    public PriceDataNotFound(String symbol) {
        this.message = "Price data for symbol: " + symbol + " not found in database.";
    }
}
