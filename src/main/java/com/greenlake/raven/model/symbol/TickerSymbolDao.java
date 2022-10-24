package com.greenlake.raven.model.symbol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticker_symbol")
public class TickerSymbolDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "symbol_id")
    long id;
    @Column(name = "symbol")
    String symbol;

    public TickerSymbolDao(String symbol) {
        this.symbol = symbol;
    }
}
