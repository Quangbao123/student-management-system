package com.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_management.dto.request.UserLoginRequest;
import com.student_management.dto.request.UserRegistrationRequest;
import com.student_management.dto.request.UserResetRequest;
import com.student_management.dto.response.ApiResponse;
import com.student_management.entities.User;
import com.student_management.service.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	// Sign up
	@PostMapping("/sign_up")
	ApiResponse<User> UserSignUp(@RequestBody @Valid UserRegistrationRequest request){
		ApiResponse<User> apiResponse = new ApiResponse<User>();
		apiResponse.setResult(loginService.registerUser(request));
		return apiResponse;
	}
	
	@PostMapping
	ResponseEntity<String> UserLogin(@RequestBody UserLoginRequest request){
		loginService.login(request);
		return ResponseEntity.ok("Login Successful");
	}
	
	@PostMapping("/reset_password")
	ResponseEntity<String> UserResetPassword(@RequestBody @Valid UserResetRequest request){
		loginService.resetPassword(request);
		return ResponseEntity.ok("Reset Password Successful");
	}
}
