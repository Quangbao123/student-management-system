package com.student_management.dto.request;

import java.time.LocalDateTime;

import com.student_management.enums.UserRole;

import jakarta.validation.constraints.Size;

public class UserRegistrationRequest {
	
	@Size(min = 4, message = "INVALID_USERNAME")
	private String username;
	
	@Size(min = 8, message = "INVALID_PASSWORD")
	private String password;
	private UserRole role;
	private Boolean isActive = true;
	private LocalDateTime lastLogin;

	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public UserRole getRole() {return role;}
	public void setRole(UserRole role) {this.role = role;}
	
	public Boolean getIsActive() {return isActive;}
	public void setIsActive(Boolean isActive) {this.isActive = isActive;}
	
	public LocalDateTime getLastLogin() {return lastLogin;}
	public void setLastLogin(LocalDateTime lastLogin) {this.lastLogin = lastLogin;}
	
	
}
