package com.student.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.model.Course;
import com.student.management.model.CourseStudentDto;
import com.student.management.model.Student;
import com.student.management.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Optional<Course> getById(int id) {
		return courseRepository.findById(id);
	}

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<CourseStudentDto> findStudentByCourseId(int id) {
		return courseRepository.findAllStudentsByCourse(id);
	}
	
}
