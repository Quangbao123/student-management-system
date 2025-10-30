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
	
	// Operate smoothly
	@PostMapping("/sign_up")
	ApiResponse<User> UserSignUp(@RequestBody @Valid UserRegistrationRequest request){
		User user = loginService.registerUser(request);
		
		ApiResponse<User> apiResponse = new ApiResponse<User>();
		apiResponse.setSuccess(true);
		apiResponse.setCode(1000);
		apiResponse.setMessage("Success");
		apiResponse.setResult(user);
		return apiResponse;
	}
	
	// Operate smoothly
	@PostMapping
	ApiResponse<String> UserLogin(@RequestBody UserLoginRequest request){
		loginService.login(request);
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		apiResponse.setSuccess(true);
		apiResponse.setCode(1000);
		apiResponse.setMessage("Success");
		
		return apiResponse;
	}
	
	// Operate smoothly
	@PostMapping("/reset_password")
	ApiResponse<String> UserResetPassword(@RequestBody @Valid UserResetRequest request){
		loginService.resetPassword(request);
		
		ApiResponse<String> apiResponse = new ApiResponse<String>();
		apiResponse.setSuccess(true);
		apiResponse.setCode(1000);
		apiResponse.setMessage("Success");
		
		return apiResponse;
	}
}
