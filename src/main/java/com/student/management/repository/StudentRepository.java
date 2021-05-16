package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.student.management.model.Student;

@NoRepositoryBean
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
