package com.project.Accounts.error.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.Accounts.constants.ApiConstants.Status;
import com.project.Accounts.error.exceptions.AccountExistsException;
import com.project.Accounts.model.ResponseMessage;

/**
 * Custom Exception Handling
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * Exception Handler when email account already exists
	 * @param AccountExistsException
	 * @return ResponseEntity
	 */
	@ExceptionHandler(value = AccountExistsException.class)
	public ResponseEntity<ResponseMessage> handleAccountExistsExceptionn(AccountExistsException e) {
		ResponseMessage errorMessage = new ResponseMessage(e.getMessage(), Status.EXISTS);
		return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
	}
}
