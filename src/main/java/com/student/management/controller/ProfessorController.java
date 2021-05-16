package com.student.management.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.model.FullTimeProfessor;
import com.student.management.model.PartTimeProfessor;
import com.student.management.model.Professor;
import com.student.management.model.RecordNotFoundException;
import com.student.management.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@GetMapping("/fullTimeProfessor/{id}")
	public ResponseEntity<Professor> getFullTimeProfessorById(@PathVariable int id){
		if(!professorService.getFullTimeProfessorbyId(id).isPresent()) {
			throw new RecordNotFoundException("Full-time Professor with id " +id + " is not found");
		}
		Professor professor=professorService.getFullTimeProfessorbyId(id).get();
		return new ResponseEntity<Professor>(professor,HttpStatus.FOUND);
	}
	
	@GetMapping("/partTimeProfessor/{id}")
	public ResponseEntity<Professor> getPartTimeProfessorById(@PathVariable int id){
		if(!professorService.getPartTimeProfessorbyId(id).isPresent()) {
			throw new RecordNotFoundException("Part-time Professor with id " +id + " is not found");
		}
		Professor professor=professorService.getPartTimeProfessorbyId(id).get();
		return new ResponseEntity<Professor>(professor,HttpStatus.FOUND);
	}
	
	@GetMapping("/fullTimeProfessors")
	public ResponseEntity<List<FullTimeProfessor>> getFullTimeProfessors(){
		List<FullTimeProfessor> professors=professorService.getAllFullTimeProfessors();
		return new ResponseEntity<List<FullTimeProfessor>>(professors,HttpStatus.FOUND);
	}
	
	@GetMapping("/partTimeProfessors")
	public ResponseEntity<List<PartTimeProfessor>> getPartTimeProfessors(){
		List<PartTimeProfessor> professors=professorService.getAllPartTimeProfessors();
		return new ResponseEntity<List<PartTimeProfessor>>(professors, HttpStatus.FOUND);
	}
	
	@PostMapping("/fullTimeProfessors/add")
	public ResponseEntity<FullTimeProfessor> addFullTimeProfessor(@RequestBody FullTimeProfessor professor){
		FullTimeProfessor prof=professorService.addFullTimeProfessor(professor);
		return new ResponseEntity<FullTimeProfessor>(prof,HttpStatus.CREATED);
	}
	
	@PostMapping("/partTimeProfessors/add")
	public ResponseEntity<PartTimeProfessor> addPartTimeProfessor(@RequestBody PartTimeProfessor professor){
		PartTimeProfessor prof=professorService.addPartTimeProfessor(professor);
		return new ResponseEntity<PartTimeProfessor>(prof,HttpStatus.CREATED);
	}
	
	@PutMapping("/partTimeProfessors/{id}/{salary}")
	public ResponseEntity<PartTimeProfessor> updatePartTimeProfessorSalary(@PathVariable int id,@PathVariable BigDecimal salary){
		if(!professorService.updatePartTimeSalaryById(id, salary).isPresent()) {
			throw new RecordNotFoundException("Part-time professor with id "+id+" is not found to update salary");
		}		
		PartTimeProfessor professor=professorService.updatePartTimeSalaryById(id, salary).get();
		return new ResponseEntity<PartTimeProfessor>(professor,HttpStatus.OK);
	}
	
	@PutMapping("/fullTimeProfessors/{id}/{salary}")
	public ResponseEntity<FullTimeProfessor> updateFullTimeProfessorSalary(@PathVariable int id,@PathVariable BigDecimal salary){
		if(!professorService.updateFullTimeSalaryById(id, salary).isPresent()) {
			throw new RecordNotFoundException("Full-time professor with id "+id+" is not found to update salary");
		}
		FullTimeProfessor professor=professorService.updateFullTimeSalaryById(id, salary).get();
		return new ResponseEntity<FullTimeProfessor>(professor,HttpStatus.OK);
	}
}
