package com.Bank.DTO.core.Events;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositBalanceEvent {
	private String accountId; 
	private BigDecimal balance;
}
