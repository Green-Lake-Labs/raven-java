package com.greenlake.raven.model.financial.earnings;

import com.greenlake.raven.model.symbol.TickerSymbolDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "cash_flow_data")
public class EarningsDataQueryDao {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "earnings_id")
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol_id", referencedColumnName = "symbol_id")
    TickerSymbolDao tickerSymbolDao;
}
