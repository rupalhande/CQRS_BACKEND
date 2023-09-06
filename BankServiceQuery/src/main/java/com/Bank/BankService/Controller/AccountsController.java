package com.Bank.BankService.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.BankService.Entity.AccountsEntity;
import com.Bank.BankService.Query.FindAccountByIdQuery;
import com.Bank.BankService.Query.FindAllAccountsQuery;


@RestController
@RequestMapping("/api/v1")
public class AccountsController {
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping("accounts")
	public ResponseEntity<?> getAllAccount(){
		
		FindAllAccountsQuery findAllAccountsQuery = new FindAllAccountsQuery();

		List<AccountsEntity> products = this.queryGateway
				.query(findAllAccountsQuery, ResponseTypes.multipleInstancesOf(AccountsEntity.class)).join();

		// List<Product> allproduct = this.service.GetAllproduct();
		return ResponseEntity.ok(products);
		
	}
	
	@GetMapping("account/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable String id){
		
		FindAccountByIdQuery findAccountByIdQuery = new FindAccountByIdQuery(id);

		CompletableFuture<AccountsEntity> product = this.queryGateway
				.query(findAccountByIdQuery, ResponseTypes.instanceOf(AccountsEntity.class));

		return ResponseEntity.ok(product);
		
	}

}
