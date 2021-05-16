package com.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.model.AadharId;
import com.student.management.model.FullTimeStudent;
import com.student.management.model.PartTimeStudent;
import com.student.management.model.Student;
import com.student.management.repository.AadharIdRepository;
import com.student.management.repository.FullTimeStudentRepository;
import com.student.management.repository.PartTimeStudentRepository;
import com.student.management.repository.StudentRepository;

import java.util.List;
import  java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	PartTimeStudentRepository partTimeStudentRepository;
	@Autowired
	FullTimeStudentRepository fullTimeStudentRepository;
	@Autowired
	AadharIdRepository aadharRepository;
	

	@Override
	public Optional<PartTimeStudent> getPartTimeStudentById(int id) {
		return partTimeStudentRepository.findById(id);
	}

	@Override
	public Optional<FullTimeStudent> getFullTimeStudentById(int id) {
		return this.fullTimeStudentRepository.findById(id);
	}

	@Override
	public List<PartTimeStudent> getAllPartTimeStudents() {
		return partTimeStudentRepository.findAllPartTimeStudent();
	}

	@Override
	public List<FullTimeStudent> getAllFullTimeStudents() {
		return fullTimeStudentRepository.findAllFullTimeStudent();
	}

	@Override
	public PartTimeStudent addPartTimeStudent(PartTimeStudent student) {
		return partTimeStudentRepository.save(student);
	}

	@Override
	public FullTimeStudent addFullTimeStudent(FullTimeStudent student) {
		return fullTimeStudentRepository.save(student);
	}

	@Override
	public int deletePartTimeStudent(int id) {
		if(partTimeStudentRepository.findById(id).isPresent()) {
			partTimeStudentRepository.deleteById(id);
			return id;
		}
		return 0;
	}

	@Override
	public int deleteFullTimeStudent(int id) {
		if(fullTimeStudentRepository.findById(id).isPresent()) {
			fullTimeStudentRepository.deleteById(id);
			return id;
		}
		return 0;
	}

	@Override
	public AadharId saveAadhar(AadharId aadhar) {
		return aadharRepository.save(aadhar);
	}

}
