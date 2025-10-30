package com.student_management.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long studentId;
	
	@Column(name = "first_name", length = 10, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 10, nullable = false)
	private String lastName;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Registration> registrations;

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

	public List<Registration> getRegistrations() {return registrations;}
	public void setRegistrations(List<Registration> registrations) {this.registrations = registrations;}
	
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
	
	
}
