package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.model.AadharId;
import com.student.management.model.FullTimeStudent;
import com.student.management.model.PartTimeStudent;
import com.student.management.model.RecordNotFoundException;
import com.student.management.model.Student;
import com.student.management.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/partTimeStudent/{id}")
	public ResponseEntity<Student> getPartTimeStudent(@PathVariable int id){
		if(!studentService.getPartTimeStudentById(id).isPresent()) {
			throw new RecordNotFoundException("Part time student record with id "+ id + " is not found");
		}
		Student student=studentService.getPartTimeStudentById(id).get();
		return new ResponseEntity<Student>(student,HttpStatus.FOUND);
	}
	
	@GetMapping("/fullTimeStudent/{id}")
	public ResponseEntity<Student> getFullTimeStudent(@PathVariable int id){
		if(!studentService.getFullTimeStudentById(id).isPresent()) {
			throw new RecordNotFoundException("Full time student record with id "+ id + " is not found");
		}
		Student student=studentService.getFullTimeStudentById(id).get();
		return new ResponseEntity<Student>(student, HttpStatus.FOUND);
	}
	
	@GetMapping("/partTimeStudents/all")
	public ResponseEntity<List<PartTimeStudent>> getAllPartTimeStudents(){
		List<PartTimeStudent> students=studentService.getAllPartTimeStudents();
		return new ResponseEntity<List<PartTimeStudent>>(students,HttpStatus.FOUND);
	}
	
	@GetMapping("/fullTimeStudents/all")
	public ResponseEntity<List<FullTimeStudent>> getAllFullTimeStudents(){
		List<FullTimeStudent> students=studentService.getAllFullTimeStudents();
		return new ResponseEntity<List<FullTimeStudent>>(students,HttpStatus.FOUND);
	}
	
	@PostMapping("/partTimeStudents/add")
	public ResponseEntity<Student> addPartTimeStudent(@RequestBody PartTimeStudent student){
		AadharId aadhar=student.getAadharId();
		studentService.saveAadhar(aadhar);
		PartTimeStudent newStudent=studentService.addPartTimeStudent(student);
		return new ResponseEntity<Student>(newStudent,HttpStatus.CREATED);
	}

	@PostMapping("/fullTimeStudents/add")
	public ResponseEntity<Student> addFullTimeStudent(@RequestBody FullTimeStudent student){
		AadharId aadhar=student.getAadharId();
		studentService.saveAadhar(aadhar);
		FullTimeStudent newStudent=studentService.addFullTimeStudent(student);
		return new ResponseEntity<Student>(newStudent,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/partTimeStudents/delete/{id}")
	public ResponseEntity<String> deletePartTimeStudent(@PathVariable int id){
		int student=studentService.deletePartTimeStudent(id);
		if(student==0) {
			throw new  RecordNotFoundException("Part time student record with id "+ id + " is not found to delete");
		}
		return new ResponseEntity<String>("Part time Student record with id "+student+" is deleted",HttpStatus.OK);
	}
	
	@DeleteMapping("/fullTimeStudents/delete/{id}")
	public ResponseEntity<String> deleteFullTimeStudent(@PathVariable int id){
		int student=studentService.deleteFullTimeStudent(id);
		if(student==0) {
			throw new  RecordNotFoundException("Full time student record with id "+ id + " is not found to delete");
		}
		return new ResponseEntity<String>("Full time Student record with id "+student+" is deleted",HttpStatus.OK);
	}
	
}
