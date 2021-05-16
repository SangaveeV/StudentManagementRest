package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.student.management.model.Professor;

@NoRepositoryBean
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
