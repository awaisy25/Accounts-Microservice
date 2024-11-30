package com.project.Accounts.model;

/**
 * Class for creating message object for certain responses like error or creation
 */
public class ResponseMessage {
	private String message;
	private int status;
	
	public ResponseMessage(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getstatus() {
		return status;
	}

	public void setstatus(int status) {
		this.status = status;
	}

}
