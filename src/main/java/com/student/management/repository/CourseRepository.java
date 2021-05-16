package com.student.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.management.model.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query("select new com.student.management.model.CourseStudentDto(c.id,c.name,s.studentName,s.address)"
			+"from Course c left join c.students s where c.id=:courseId")
	List<CourseStudentDto> findAllStudentsByCourse(int courseId);
	
}
