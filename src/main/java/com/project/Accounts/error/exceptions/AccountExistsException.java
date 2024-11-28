package com.project.Accounts.error.exceptions;

/**
 * Custom Exception when account email already exists
 */
public class AccountExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AccountExistsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
