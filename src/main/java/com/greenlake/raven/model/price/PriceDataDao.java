package com.greenlake.raven.model.price;

import com.greenlake.raven.model.symbol.TickerSymbolDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price_data")
public class PriceDataDao implements PriceData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_data_id")
    long id;
    @Column(name = "symbol_id")
    long symbolId;
    @Column(name = "symbol")
    String symbol;
    @Column(name = "open")
    float open;
    @Column(name = "high")
    float high;
    @Column(name = "low")
    float low;
    @Column(name = "close")
    float close;
    @Column(name = "adj_close")
    float adjClose;
    @Column(name = "volume")
    float volume;
    @Column(name = "date")
    LocalDate date;

    public PriceDataDao(TickerSymbolDao tickerSymbolDao, PriceDataResponse.HistoricalPriceRaw historicalPriceRaw) {
        this.symbolId = tickerSymbolDao.getId();
        this.symbol = tickerSymbolDao.getSymbol();
        this.open = historicalPriceRaw.open;
        this.high = historicalPriceRaw.high;
        this.low = historicalPriceRaw.low;
        this.close = historicalPriceRaw.close;
        this.adjClose = historicalPriceRaw.adjClose;
        this.volume = historicalPriceRaw.volume;
        this.date = historicalPriceRaw.date;
    }
}
