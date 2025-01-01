package com.project.Accounts.controllers;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.Accounts.service.AccountServiceImpl;
import com.project.Accounts.service.OauthService;
import com.project.Accounts.model.Account;
import com.project.Accounts.model.JwtToken;
import com.project.Accounts.model.ResponseMessage;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTests {
	
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountServiceImpl accountService;
	
	@Mock
	OauthService oauthService;
	
	@Test
	public void testGetAccounts() {
		Account account1 = new Account("test@gmail.com", "foo", true);
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		//mocking the fetch accounts
		when(accountService.fetchAccounts()).thenReturn(accounts);
		ResponseEntity<ArrayList<Account>> response = accountController.getAccounts();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		Account reponseAccount = response.getBody().get(0);
		assertEquals(reponseAccount, account1);
	}
	
	@Test 
	public void testRegisterAccountSuccess() {
		Account account1 = new Account("test@gmail.com", "foo", true);
		JwtToken token = new JwtToken();
		token.setAccess_token("test");
		when(oauthService.generateToken()).thenReturn(token);
		ResponseEntity<ResponseMessage> response = accountController.registerAccount(account1);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertEquals(response.getBody().getToken(), token);
	}
}
