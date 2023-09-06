package com.Bank.BankService.Query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.BankService.Entity.AccountsEntity;
import com.Bank.BankService.Repository.AccountsRepository;
import com.Bank.DTO.core.Events.AccountCreatedEvent;

@Component
@ProcessingGroup("create-account-group")
public class AccountEventHandler {
	@Autowired
	private AccountsRepository accountsRepository;

	@EventHandler
	public void on(AccountCreatedEvent accountCreatedEvent) {
		AccountsEntity currentAccount = AccountsEntity.builder()
		.accountId(accountCreatedEvent.getAccountId())
		.accountHolderName(accountCreatedEvent.getAccountHolderName())
		.accountType(accountCreatedEvent.getAccountType())
		.balance(accountCreatedEvent.getBalance())
		.status(accountCreatedEvent.getStatus())
		.build();
		System.out.println("here ");
		this.accountsRepository.save(currentAccount);
	}
}
