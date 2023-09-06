package com.Bank.BankService.Command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class WithdrawBalanceCommand {
	@TargetAggregateIdentifier
	private String accountId; 
	private BigDecimal balance;
}
