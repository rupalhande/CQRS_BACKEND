package com.Bank.DTO.core.Events;

import java.math.BigDecimal;

import com.Bank.DTO.dto.AccountStatus;
import com.Bank.DTO.dto.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreatedEvent {
	private String accountId; 
	private String accountHolderName;
	private AccountType accountType;
	private BigDecimal balance;
	private AccountStatus status;
}
