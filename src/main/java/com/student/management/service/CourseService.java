package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.model.Course;
import com.student.management.model.CourseStudentDto;
import com.student.management.model.Student;
public interface CourseService {

	List<Course> getAllCourses();
	Optional<Course> getById(int id);
	Course addCourse(Course course);
	
	List<CourseStudentDto> findStudentByCourseId(int id);
}
