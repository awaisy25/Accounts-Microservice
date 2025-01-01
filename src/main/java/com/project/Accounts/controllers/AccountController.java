package com.project.Accounts.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Accounts.constants.ApiConstants.Status;
import com.project.Accounts.model.Account;
import com.project.Accounts.model.JwtToken;
import com.project.Accounts.model.ResponseMessage;
import com.project.Accounts.service.AccountServiceImpl;
import com.project.Accounts.service.OauthService;

@RestController
public class AccountController  {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@Autowired
	private OauthService oauthService;
	
	
	@PostMapping(value="/register")
	public ResponseEntity<ResponseMessage> registerAccount(@RequestBody Account accountBody) {
		Account account = new Account(accountBody.getEmail(), accountBody.getPassword(), true);
		JwtToken token = oauthService.generateToken();
		ResponseMessage response = new ResponseMessage(accountService.saveAccount(account), Status.SUCCESSFUL);
		response.setAccountId(account.getID());
		response.setToken(token);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/api/accounts")
	public ResponseEntity<ArrayList<Account>> getAccounts() {
		return new ResponseEntity<>(accountService.fetchAccounts(), HttpStatus.OK);
	}
}
