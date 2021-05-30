package com.parwej.employeeManager.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
