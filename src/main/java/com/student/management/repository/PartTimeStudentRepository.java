package com.student.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.management.model.PartTimeStudent;

@Repository
public interface PartTimeStudentRepository extends StudentRepository {

	@Query("from PartTimeStudent")
	List<PartTimeStudent> findAllPartTimeStudent();
	
	@Query("from PartTimeStudent where id=:id")
	Optional<PartTimeStudent> findById(int id);
}
