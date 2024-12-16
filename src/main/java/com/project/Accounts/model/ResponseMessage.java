package com.project.Accounts.model;

import com.project.Accounts.constants.ApiConstants.Status;

/**
 * Class for creating message object for certain responses like error or creation
 */
public class ResponseMessage {
	private String message;
	private Status status;
	private Long accountId;
	
	public ResponseMessage(String message, Status status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	//parameters for login and register
	public ResponseMessage(String message, Status status, Long accountId) {
		this.message = message;
		this.status = status;
		this.setAccountId(accountId);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getstatus() {
		return status;
	}

	public void setstatus(Status status) {
		this.status = status;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
