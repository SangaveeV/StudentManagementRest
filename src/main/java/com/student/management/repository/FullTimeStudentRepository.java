package com.student.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.management.model.FullTimeStudent;
import com.student.management.model.Student;

@Repository
public interface FullTimeStudentRepository extends StudentRepository{

	@Query("from FullTimeStudent")
	List<FullTimeStudent> findAllFullTimeStudent();
	
	@Query("from FullTimeStudent where id=:id")
	Optional<FullTimeStudent> findById(int id);
	
}
