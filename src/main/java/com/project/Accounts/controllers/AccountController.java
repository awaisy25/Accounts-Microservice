package com.project.Accounts.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Accounts.model.Account;
import com.project.Accounts.service.AccountServiceImpl;

@RestController
public class AccountController  {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@PostMapping(value="/accounts")
	public String createAccount(@RequestBody Account accountBody) {
		Account account = new Account(accountBody.getUsername(), accountBody.getPassword(), true, accountBody.getEmail());
		try {
			accountService.saveAccount(account);
			return "Account Succesfully created";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping(value="/accounts")
	public ArrayList<Account> getAccounts() {
		return accountService.fetchAccounts();
	}
}
