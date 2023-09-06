package com.Bank.BankService.Command;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.BankService.Entity.AccountsLookup;
import com.Bank.BankService.Repository.AccountsLookupRepository;
import com.Bank.DTO.core.Events.AccountCreatedEvent;

@Component
@ProcessingGroup("create-account-group")
public class AccountLookupEventHandler {
	private final static Logger log = LoggerFactory.getLogger(AccountLookupEventHandler.class);
	
	@Autowired
	private AccountsLookupRepository repository;

	@EventHandler
	public void on(AccountCreatedEvent accountCreatedEvent) {
		AccountsLookup lookup = new AccountsLookup(accountCreatedEvent.getAccountHolderName());
		log.info("Accounts Lookup created :- {} ", lookup);
		this.repository.save(lookup);
	}
}
