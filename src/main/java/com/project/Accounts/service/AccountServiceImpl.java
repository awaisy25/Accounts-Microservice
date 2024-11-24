package com.project.Accounts.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Accounts.model.Account;
import com.project.Accounts.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repository;

	@Override
	public ArrayList<Account> fetchAccounts() {
		return (ArrayList<Account>) repository.findAll();
	}

	@Override
	public void saveAccount(Account newAccount) throws Exception {
		//logic to check is email already exists
		String email = newAccount.getEmail();
		if(this.fetchAccounts().stream().filter(account -> account.getEmail().equals(email)).findFirst().orElse(null) != null) {
			throw new Exception("Account Already Exists");
		}
		repository.save(newAccount);
	}

}
