package com.Bank.BankService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.BankService.Entity.AccountsLookup;

public interface AccountsLookupRepository extends JpaRepository<AccountsLookup, String> {

}
