package com.greenlake.raven.model.financial.balancesheet;

import com.greenlake.raven.model.symbol.TickerSymbolDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "balance_sheet_data")
public class BalanceSheetDataQueryDao {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "balance_sheet_id")
    long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "symbol_id", referencedColumnName = "symbol_id")
    TickerSymbolDao tickerSymbolDao;
}
