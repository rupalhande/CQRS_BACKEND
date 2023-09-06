package com.Bank.BankService.Command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CloseAccountCommand {
	@TargetAggregateIdentifier
	private String accountId;
}
