package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.model.Course;
import com.student.management.model.CourseStudentDto;
import com.student.management.model.RecordNotFoundException;
import com.student.management.model.Student;
import com.student.management.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		List<Course> courses=courseService.getAllCourses();
		return new ResponseEntity<List<Course>>(courses,HttpStatus.FOUND);		
	}

	@GetMapping("/getCourse/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id) {
		if(!courseService.getById(id).isPresent()) {
			throw new RecordNotFoundException("Course id "+id+" does not exist");
		}
		Course course= courseService.getById(id).get();
		return new ResponseEntity<Course>(course,HttpStatus.FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course newCourse= courseService.addCourse(course);
		return new ResponseEntity<Course>(newCourse,HttpStatus.CREATED);
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<List<CourseStudentDto>> getStudentByCourseId(@PathVariable int id){
		if(!courseService.getById(id).isPresent()) {
			throw new RecordNotFoundException("No course with course id "+id+" is found");
		}
		if(courseService.findStudentByCourseId(id).isEmpty()) {
			throw new RecordNotFoundException("No students have been registered for the course id "+id);
		}
		List<CourseStudentDto> students=courseService.findStudentByCourseId(id);
		return new ResponseEntity<List<CourseStudentDto>>(students,HttpStatus.FOUND);
	}

}
