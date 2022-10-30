package com.greenlake.raven.model.financial.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "income_data")
public class IncomeDataDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "income_id")
    long id;

    @Column(name = "symbol_id")
    long symbolId;
}
