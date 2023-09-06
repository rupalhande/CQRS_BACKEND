package com.Bank.BankService.Controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.BankService.Command.CreateAccountCommand;
import com.Bank.BankService.Req.CreateAccountReq;
import com.Bank.DTO.dto.AccountType;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
	@Autowired
	private CommandGateway commandGateway;

	@PostMapping("accounts")
	public ResponseEntity<?> CreateAccount(@Valid @RequestBody CreateAccountReq req) throws Exception{
		CreateAccountCommand createAccountCommand = CreateAccountCommand.builder()
		.accountId(UUID.randomUUID().toString())
		.accountHolderName(req.getAccountHolderName())
		.balance(req.getBalance())
		.build();
		
		if(req.getAccountType().toLowerCase().equals("savings")) {
			createAccountCommand.setAccountType(AccountType.SAVINGS);
		}
		else if(req.getAccountType().toLowerCase().equals("current")) {
			createAccountCommand.setAccountType(AccountType.CURRENT);
		}
		else {
			throw new Exception("Invalid account type!");
		}
		String response;
		try {
			response = this.commandGateway.sendAndWait(createAccountCommand);			
		} catch (Exception e) {
			throw e;
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
