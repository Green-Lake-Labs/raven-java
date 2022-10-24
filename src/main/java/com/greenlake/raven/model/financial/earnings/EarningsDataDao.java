package com.greenlake.raven.model.financial.earnings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "earnings_data")
public class EarningsDataDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "earnings_id")
    long id;

    @Column(name = "symbol_id")
    long symbolId;
}
