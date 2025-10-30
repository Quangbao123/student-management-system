package com.student_management.enums;

public enum ErrorCode {
	
	UNCATEGORIZED_EXCEPTION(9999, "Uncategorized"),
	USER_EXISTED(1001, "User existed"),
	INVALID_LOGIN(1002, "Invalid username or password"),
	INVALID_USERNAME(1003, "Username must be at least 4 charactes"),
	INVALID_PASSWORD(1004, "Password must be at least 8 characters"),
	INVALID_NEWPASSWORD(1005, "New password must be at least 8 characters"),
	INVALID_PREVIOUS_USERNAME(1006, "Invalid username"),
	USER_NOT_FOUND(1007, "User not found");
	
	private final int code;
	private final String message;
	
	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
