package com.student_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_management.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student> findByUser_UserId(Long userId); 
}
