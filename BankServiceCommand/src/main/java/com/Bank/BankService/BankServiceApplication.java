package com.Bank.BankService;

import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import com.Bank.BankService.Command.Interceptor.CreateAccountInterceptor;

@SpringBootApplication
@EnableDiscoveryClient
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}

	@Autowired
	public void registerInterceptor(ApplicationContext contex,CommandBus commandBus) {
		commandBus.registerDispatchInterceptor(contex.getBean(CreateAccountInterceptor.class));
	}
}
