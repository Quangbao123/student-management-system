package com.student_management.entities;

import java.time.LocalDateTime;

import com.student_management.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name="user_name", length = 20, nullable = false)
	private String username;
	
	@Column(name = "password", length = 20, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private UserRole role;
	
	@OneToOne(mappedBy = "user")
	private Student student;
	
	@Column(name = "is_active")
	private Boolean isActive = true;
	
	@Column(name = "last_login")
	private LocalDateTime lastLogin;

	
	// Getter & setter
	public Long getUserId() {return userId;}
	public void setUserId(Long userId) {this.userId = userId;}

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
