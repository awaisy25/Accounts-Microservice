package com.project.Accounts.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> createAccount(@RequestBody Account accountBody) {
		Account account = new Account(accountBody.getUsername(), accountBody.getPassword(), true, accountBody.getEmail());
		try {
			accountService.saveAccount(account);
			return new ResponseEntity<>("Account Succesfully created", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/accounts")
	public ResponseEntity<ArrayList<Account>> getAccounts() {
		return new ResponseEntity<>(accountService.fetchAccounts(), HttpStatus.OK);
	}
}
