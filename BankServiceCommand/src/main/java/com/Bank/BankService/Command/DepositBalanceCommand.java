package com.Bank.BankService.Command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DepositBalanceCommand {
	@TargetAggregateIdentifier
	private String accountId; 
	private BigDecimal balance;
}
