package com.student_management.dto.request;

import jakarta.validation.constraints.Size;

public class UserResetRequest {
	private String username;
	@Size(min = 8, message = "New password must be at least 8 characters")
	private String password;
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}
