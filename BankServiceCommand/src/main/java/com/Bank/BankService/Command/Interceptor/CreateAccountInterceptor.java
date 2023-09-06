package com.Bank.BankService.Command.Interceptor;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bank.BankService.Command.CreateAccountCommand;
import com.Bank.BankService.Entity.AccountsLookup;
import com.Bank.BankService.Repository.AccountsLookupRepository;

@Component
public class CreateAccountInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {
	@Autowired
	private AccountsLookupRepository repository;

	@Override
	public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
			List<? extends CommandMessage<?>> messages) {

		return (index, command) -> {
			if (CreateAccountCommand.class.equals(command.getPayloadType())) {
				
				CreateAccountCommand createAccountCommand = (CreateAccountCommand) command.getPayload();

				this.repository.findById(createAccountCommand.getAccountHolderName())
						.orElseThrow(() -> new IllegalStateException("account with AccountHolderName "
								+ createAccountCommand.getAccountHolderName() + "alredy exists!"));

			}

			return command;
		};
	}

}
