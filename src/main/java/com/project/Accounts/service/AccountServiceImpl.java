package com.project.Accounts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Accounts.model.Account;
import com.project.Accounts.repository.AccountRepository;
import com.project.Accounts.error.exceptions.AccountExistsException;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;

	@Override
	public ArrayList<Account> fetchAccounts() {
		List<Account> accounts = repository.findAll();
		return new ArrayList<>(accounts);
	}

	@Override
	public String saveAccount(Account newAccount) {
		//logic to check is email already exists
		String email = newAccount.getEmail();
		if(this.fetchAccounts().stream().filter(account -> account.getEmail().equals(email)).findFirst().orElse(null) != null) {
			throw new AccountExistsException("Email Account Already Exists");
		}
		repository.save(newAccount);
		return "Account Succesfully created";
	}

}
