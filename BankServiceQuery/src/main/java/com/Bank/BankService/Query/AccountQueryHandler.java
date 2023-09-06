package com.Bank.BankService.Query;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.BankService.Entity.AccountsEntity;
import com.Bank.BankService.Repository.AccountsRepository;


@Component
public class AccountQueryHandler {
	@Autowired
	private AccountsRepository accountsRepository;

	@QueryHandler
	public List<AccountsEntity> findAllAccount(FindAllAccountsQuery query) {
		List<AccountsEntity> allAccounts = this.accountsRepository.findAll();

		return allAccounts;
	}
	
	@QueryHandler
	public AccountsEntity findAccountById(FindAccountByIdQuery query) throws Exception {
		AccountsEntity Account = this.accountsRepository.findById(query.getId()).orElseThrow(()->new Exception("Account not found for id :- "+query.getId()));

		return Account;
	}
}
