package com.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student_management.entities.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>{

}
