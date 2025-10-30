package com.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_management.dto.request.StudentUpdatingRequest;
import com.student_management.entities.Student;
import com.student_management.enums.ErrorCode;
import com.student_management.exception.CustomException;
import com.student_management.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student updatePersonalProfile(StudentUpdatingRequest request) {
		// search student by Id
		Student student = studentRepository.findByUser_UserId(request.getUserId())
				.orElseThrow(() -> new RuntimeException("Student not found"));

		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setAge(request.getAge());
		student.setEmail(request.getEmail());

		return studentRepository.save(student);
	}
	
	public Student viewPersonalProfile(Long userId) {
		Student student = studentRepository.findByUser_UserId(userId)
				.orElseThrow(()-> new CustomException(ErrorCode.USER_NOT_FOUND));
		return student;
	}
}
