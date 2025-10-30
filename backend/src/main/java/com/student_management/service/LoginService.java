package com.student_management.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.student_management.dto.request.UserLoginRequest;
import com.student_management.dto.request.UserRegistrationRequest;
import com.student_management.dto.request.UserResetRequest;
import com.student_management.entities.Student;
import com.student_management.entities.User;
import com.student_management.enums.ErrorCode;
import com.student_management.enums.UserRole;
import com.student_management.exception.CustomException;
import com.student_management.repository.StudentRepository;
import com.student_management.repository.UserRepository;

@Service
@Validated
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public User registerUser(UserRegistrationRequest request) {
		// check duplicate username
		if(userRepository.existsByUsername(request.getUsername())) 
			throw new CustomException(ErrorCode.USER_EXISTED);

		User user = new User();

		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setRole(UserRole.USER);
		user.setIsActive(true);
		user.setLastLogin(null);

		User savedUser = userRepository.save(user);

		// create student
		Student student = new Student();
		student.setFirstName("default");
		student.setLastName("default");
		student.setEmail(request.getUsername()+"@placeholder.com");
		student.setUser(savedUser);
		studentRepository.save(student);

		return savedUser;
	}
	
	public void login(UserLoginRequest request) {
		// check username
		User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new CustomException(ErrorCode.INVALID_LOGIN));
		
		// check password
		if(!user.getPassword().equals(request.getPassword()))
			throw new CustomException(ErrorCode.INVALID_LOGIN);
		
		// update last login after login successful
		user.setLastLogin(LocalDateTime.now());
		userRepository.save(user);
	}
	
	public void resetPassword(UserResetRequest request) {
		// check username
		User user = userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new CustomException(ErrorCode.INVALID_PREVIOUS_USERNAME));
		
		user.setPassword(request.getPassword());
		userRepository.save(user);
	}
}
