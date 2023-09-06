package com.Bank.BankService.Req;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.
import lombok.Data;

@Data
public class CreateAccountReq {
	@NotBlank(message = "Account holder name can't be empty")
	private String accountHolderName;
	@NotBlank(message = "Account type can't be empty")
	private String accountType;
	@Min(value = 0,message = "balance can't be less than 0")
	private BigDecimal balance;
}
