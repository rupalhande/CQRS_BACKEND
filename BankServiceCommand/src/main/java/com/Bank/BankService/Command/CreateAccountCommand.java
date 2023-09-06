package com.Bank.BankService.Command;

import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.Bank.DTO.dto.AccountStatus;
import com.Bank.DTO.dto.AccountType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAccountCommand {

	@TargetAggregateIdentifier
	private String accountId; 
	private String accountHolderName;
	private AccountType accountType;
	private BigDecimal balance;
	private AccountStatus status;
}
