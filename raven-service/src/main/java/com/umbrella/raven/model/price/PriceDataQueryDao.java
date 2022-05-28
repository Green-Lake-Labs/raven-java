package com.umbrella.raven.model.price;

import com.umbrella.raven.model.symbol.TickerSymbolDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "price_data")
public class PriceDataQueryDao {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "symbol_id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol_id", referencedColumnName = "symbol_id")
    TickerSymbolDao tickerSymbolDao;
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
}
