package com.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_management.dto.request.StudentUpdatingRequest;
import com.student_management.dto.response.ApiResponse;
import com.student_management.entities.Student;
import com.student_management.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/homepage/user")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/update/{userId}")
	ApiResponse<Student> updatePersonalProfile(@RequestBody @Valid StudentUpdatingRequest request,
			@PathVariable Long userId){
		request.setUserId(userId);
		
		ApiResponse<Student> apiResponse = new ApiResponse<Student>();
		apiResponse.setSuccess(true);
		apiResponse.setCode(1000);
		apiResponse.setMessage("Success");
		apiResponse.setResult(studentService.updatePersonalProfile(request));
		
		return apiResponse;
	}
	
	@GetMapping("/view/{userId}")
	ApiResponse<Student> viewPersonalProfile(@PathVariable Long userId){
		Student student =  studentService.viewPersonalProfile(userId);
		
		ApiResponse<Student> apiResponse = new ApiResponse<Student>();
		apiResponse.setSuccess(true);
		apiResponse.setCode(1000);
		apiResponse.setMessage("Success");
		apiResponse.setResult(student);
		
		return apiResponse;
	}
}
