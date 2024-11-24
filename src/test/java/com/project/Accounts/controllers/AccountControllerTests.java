package com.project.Accounts.controllers;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.Accounts.service.AccountServiceImpl;
import com.project.Accounts.model.Account;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTests {
	
	@InjectMocks
	AccountController accountController;
	
	@Mock
	AccountServiceImpl accountService;
	
	@Test
	public void testGetAccounts() {
		Account account1 = new Account("test1", "foo", true, "test@gmail.com");
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		//mocking the fetch accounts
		when(accountService.fetchAccounts()).thenReturn(accounts);
		ArrayList<Account> results = accountController.getAccounts();
		assertEquals(results.size(), 1);
		assertEquals(results.get(0).getUsername(), "test1");
	}
}
