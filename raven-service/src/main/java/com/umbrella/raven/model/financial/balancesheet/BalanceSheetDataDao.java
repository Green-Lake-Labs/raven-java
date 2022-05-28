package com.umbrella.raven.model.financial.balancesheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "balance_sheet_data")
public class BalanceSheetDataDao {
}
