package com.student_management.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentUpdatingRequest {
	private Long studentId;
	
	@NotBlank(message = "First name must not blank")
	@Size(max = 10, message = "First name must be at most 10 characters")
	private String firstName;
	
	@NotBlank(message = "Last name must not blank")
	@Size(max = 10, message = "Last name must be at most 10 characters")
	private String lastName;
	
	private Integer age;
	
	@NotBlank(message = "Email must not blank")
	@Email(message = "Email is invalid")
	private String email;
	private Long userId;

	
	
	// Getter & Setter
	public Long getStudentId() {return studentId;}
	public void setStudentId(Long studentId) {this.studentId = studentId;}
	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	public Integer getAge() {return age;}
	public void setAge(Integer age) {this.age = age;}

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
	
}
