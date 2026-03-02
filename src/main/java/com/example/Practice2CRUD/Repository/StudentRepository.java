package com.example.Practice2CRUD.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Practice2CRUD.Entity.Student;

public interface  StudentRepository extends JpaRepository<Student, Integer> {
  Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);  
    
}
