package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface StudentRepositery extends JpaRepository<Student, Long> {
	 List <Student> findByName(String Name); 
}
