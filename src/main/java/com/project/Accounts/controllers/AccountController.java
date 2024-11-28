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
import com.project.Accounts.model.ResponseMessage;
import com.project.Accounts.service.AccountServiceImpl;

@RestController
public class AccountController  {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@PostMapping(value="/accounts")
	public ResponseEntity<ResponseMessage> createAccount(@RequestBody Account accountBody) {
		Account account = new Account(accountBody.getUsername(), accountBody.getPassword(), true, accountBody.getEmail());
		ResponseMessage response = new ResponseMessage(accountService.saveAccount(account), 200); 
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/accounts")
	public ResponseEntity<ArrayList<Account>> getAccounts() {
		return new ResponseEntity<>(accountService.fetchAccounts(), HttpStatus.OK);
	}
}
