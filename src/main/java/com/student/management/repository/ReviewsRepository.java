package com.student.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.model.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Integer>{
	
	List<Reviews> findByCourseId(Integer courseId);
}
