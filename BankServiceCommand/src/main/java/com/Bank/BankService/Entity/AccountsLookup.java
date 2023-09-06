package com.Bank.BankService.Entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts_lookup")
public class AccountsLookup implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique = true) 
	private String accountHolderName;
}
