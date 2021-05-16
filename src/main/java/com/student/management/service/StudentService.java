package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.model.AadharId;
import com.student.management.model.FullTimeStudent;
import com.student.management.model.PartTimeStudent;
import com.student.management.model.Student;

public interface StudentService {

	Optional<PartTimeStudent> getPartTimeStudentById(int id);
	List<PartTimeStudent> getAllPartTimeStudents();
	PartTimeStudent addPartTimeStudent(PartTimeStudent student);
	int deletePartTimeStudent(int id);
	
	Optional<FullTimeStudent> getFullTimeStudentById(int id);
	List<FullTimeStudent> getAllFullTimeStudents();
	FullTimeStudent addFullTimeStudent(FullTimeStudent student);
	int deleteFullTimeStudent(int id);
	
	AadharId saveAadhar(AadharId aadhar);
	
}
