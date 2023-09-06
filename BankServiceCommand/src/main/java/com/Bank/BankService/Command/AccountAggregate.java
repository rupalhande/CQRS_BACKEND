package com.Bank.BankService.Command;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.Bank.DTO.core.Events.AccountCreatedEvent;
import com.Bank.DTO.core.Events.AccountUpdateEvent;
import com.Bank.DTO.core.Events.AccountCloseEvent;
import com.Bank.DTO.core.Events.DepositBalanceEvent;
import com.Bank.DTO.core.Events.WithdrawBalanceEvent;
import com.Bank.DTO.dto.AccountStatus;
import com.Bank.DTO.dto.AccountType;

@Aggregate
public class AccountAggregate {
	@AggregateIdentifier
	private String accountId;
	private String accountHolderName;
	private AccountType accountType;
	private BigDecimal balance;
	private AccountStatus status;

	public AccountAggregate() {

	}

	@CommandHandler
	public AccountAggregate(CreateAccountCommand createAccountCommand) {

		AccountCreatedEvent accountCreatedEvent = new AccountCreatedEvent();

		BeanUtils.copyProperties(createAccountCommand, accountCreatedEvent);

		AggregateLifecycle.apply(accountCreatedEvent);
	}

	@EventSourcingHandler
	public void on(AccountCreatedEvent accountCreatedEvent) {
		this.accountId = accountCreatedEvent.getAccountId();
		this.accountHolderName = accountCreatedEvent.getAccountHolderName();
		this.accountType = accountCreatedEvent.getAccountType();
		this.balance = accountCreatedEvent.getBalance();
		this.status = accountCreatedEvent.getStatus();
	}

	@CommandHandler
	public AccountAggregate(UpdateAccountCommand updateAccountCommand) {

		AccountUpdateEvent accountUpdateEvent = new AccountUpdateEvent();

		BeanUtils.copyProperties(updateAccountCommand, accountUpdateEvent);

		AggregateLifecycle.apply(accountUpdateEvent);
	}

	@EventSourcingHandler
	public void on(AccountUpdateEvent accountUpdateEvent) {
		this.accountId = accountUpdateEvent.getAccountId();
		this.accountHolderName = (this.accountHolderName == accountUpdateEvent.getAccountHolderName())
				? this.accountHolderName
				: accountUpdateEvent.getAccountHolderName();
		this.accountType = (this.accountType == accountUpdateEvent.getAccountType()) ? this.accountType
				: accountUpdateEvent.getAccountType();
		this.balance = (this.balance == accountUpdateEvent.getBalance()) ? this.balance
				: accountUpdateEvent.getBalance();
		this.status = (this.status == accountUpdateEvent.getStatus()) ? this.status : accountUpdateEvent.getStatus();
	}
	
	@CommandHandler
	public AccountAggregate(CloseAccountCommand closeAccountCommand) {

		AccountCloseEvent accountCloseEvent = new AccountCloseEvent();

		BeanUtils.copyProperties(closeAccountCommand, accountCloseEvent);

		AggregateLifecycle.apply(accountCloseEvent);
	}

	@EventSourcingHandler
	public void on(AccountCloseEvent accountCloseEvent) {
		this.accountId = accountCloseEvent.getAccountId();
		this.status = AccountStatus.INACTIVE;
	}
	
	@CommandHandler
	public AccountAggregate(DepositBalanceCommand depositBalanceCommand) {

		DepositBalanceEvent depositBalanceEvent = new DepositBalanceEvent();

		BeanUtils.copyProperties(depositBalanceCommand, depositBalanceEvent);

		AggregateLifecycle.apply(depositBalanceEvent);
	}

	@EventSourcingHandler
	public void on(DepositBalanceEvent depositBalanceEvent) {
		this.accountId = depositBalanceEvent.getAccountId();
		this.balance=this.balance.add(depositBalanceEvent.getBalance());
	}
	
	@CommandHandler
	public AccountAggregate(WithdrawBalanceCommand withdrawBalanceCommand) {

		WithdrawBalanceEvent withdrawBalanceEvent = new WithdrawBalanceEvent();

		BeanUtils.copyProperties(withdrawBalanceCommand, withdrawBalanceEvent);

		AggregateLifecycle.apply(withdrawBalanceEvent);
	}

	@EventSourcingHandler
	public void on(WithdrawBalanceEvent withdrawBalanceEvent) {
		this.accountId = withdrawBalanceEvent.getAccountId();
		this.balance=this.balance.subtract(withdrawBalanceEvent.getBalance());
	}
}
