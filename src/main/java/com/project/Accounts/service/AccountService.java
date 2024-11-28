package com.project.Accounts.service;

import java.util.ArrayList;

import com.project.Accounts.model.Account;

public interface AccountService {
	ArrayList<Account> fetchAccounts();
	String saveAccount(Account newAccount);
	
}
