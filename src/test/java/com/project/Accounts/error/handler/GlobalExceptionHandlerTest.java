package com.project.Accounts.error.handler;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.Accounts.error.exceptions.AccountExistsException;
import com.project.Accounts.model.ResponseMessage;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {
	@InjectMocks
	GlobalExceptionHandler exceptionHandler;
	
	@Test
	public void testHandleAccountExistException() {
		AccountExistsException exception = new AccountExistsException("Account Exists");
		ResponseEntity<ResponseMessage> response = exceptionHandler.handleAccountExistsExceptionn(exception);
		assertEquals(response.getStatusCode(), HttpStatus.CONFLICT);
		assertEquals(response.getBody().getMessage(), "Account Exists");
	}

}
