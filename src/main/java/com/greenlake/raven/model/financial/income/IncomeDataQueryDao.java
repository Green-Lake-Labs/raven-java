package com.greenlake.raven.model.financial.income;

import com.greenlake.raven.model.symbol.TickerSymbolDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "income_data")
public class IncomeDataQueryDao {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "income_id")
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol_id", referencedColumnName = "symbol_id")
    TickerSymbolDao tickerSymbolDao;
}
