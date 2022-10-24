package com.greenlake.raven.model.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDataImpl implements PriceData {

    String symbol;
    float open;
    float high;
    float low;
    float close;
    float adjClose;
    float volume;
    LocalDate date;

    public PriceDataImpl(PriceDataDao priceDataDao) {
        this.symbol = priceDataDao.symbol;
        this.open = priceDataDao.open;
        this.high = priceDataDao.high;
        this.low = priceDataDao.low;
        this.close = priceDataDao.close;
        this.adjClose = priceDataDao.adjClose;
        this.volume = priceDataDao.volume;
        this.date = priceDataDao.date;
    }

    public PriceDataImpl(PriceDataQueryDao priceDataQueryDao) {
        this.symbol = priceDataQueryDao.symbol;
        this.open = priceDataQueryDao.open;
        this.high = priceDataQueryDao.high;
        this.low = priceDataQueryDao.low;
        this.close = priceDataQueryDao.close;
        this.adjClose = priceDataQueryDao.adjClose;
        this.volume = priceDataQueryDao.volume;
        this.date = priceDataQueryDao.date;
    }
}
