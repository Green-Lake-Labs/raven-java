package com.greenlake.raven.model.financial.cashflow;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cash_flow_data")
public class CashFlowDataDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cash_flow_id")
    long id;

    @Column(name = "symbol_id")
    long symbolId;
}
