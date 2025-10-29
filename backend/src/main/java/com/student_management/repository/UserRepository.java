package com.student_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_management.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	boolean existsByUsername(String username);
	boolean existsByPassword(String password);
	Optional<User> findByUsername(String username);
}
