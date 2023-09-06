package com.Bank.BankService.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.BankService.Entity.AccountsEntity;

public interface AccountsRepository extends JpaRepository<AccountsEntity, String>{

}
