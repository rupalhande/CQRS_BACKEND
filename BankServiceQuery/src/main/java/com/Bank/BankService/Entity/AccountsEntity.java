package com.Bank.BankService.Entity;

import java.math.BigDecimal;



import com.Bank.DTO.dto.AccountStatus;
import com.Bank.DTO.dto.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "bank-account")
@Data
@Builder
public class AccountsEntity {
	@Id
	private String accountId; 
	private String accountHolderName;
	private AccountType accountType;
	private BigDecimal balance;
	private AccountStatus status;
}
