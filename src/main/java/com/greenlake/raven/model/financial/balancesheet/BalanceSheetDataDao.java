package com.greenlake.raven.model.financial.balancesheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "balance_sheet_data")
public class BalanceSheetDataDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "balance_sheet_id")
    long id;

    @Column(name = "symbol_id")
    long symbolId;
}
