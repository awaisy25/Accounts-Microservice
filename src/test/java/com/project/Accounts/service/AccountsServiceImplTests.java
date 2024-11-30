package com.project.Accounts.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.Accounts.error.exceptions.AccountExistsException;
import com.project.Accounts.model.Account;
import com.project.Accounts.repository.AccountRepository;
@ExtendWith(MockitoExtension.class)
public class AccountsServiceImplTests {
	
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Mock
	private AccountRepository repository;
	
	@Test
	public void testFetchAccounts() {
		Account account1 = new Account("test1", "foo", true, "test@gmail.com");
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		when(repository.findAll()).thenReturn(accounts);
		ArrayList<Account> accountsResult = accountService.fetchAccounts();
		assertEquals(accountsResult.size(), 1);
	}
	
	@Test
	public void testAccountSaves() {
		Account account2 = new Account("test2", "foo", true, "test2@gmail.com");
		assertEquals(accountService.saveAccount(account2), "Account Succesfully created");
	}
	@Test
	public void testAccountExistsisThrown() {
		Account account1 = new Account("test1", "foo", true, "test@gmail.com");
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account1);
		when(repository.findAll()).thenReturn(accounts);
		//email same as first account
		Account account2 = new Account("test1", "foo", true, "test@gmail.com");
		assertThrows(AccountExistsException.class, () -> accountService.saveAccount(account2));
	}
	
}
