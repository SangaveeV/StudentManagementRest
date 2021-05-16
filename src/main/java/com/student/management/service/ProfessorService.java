package com.student.management.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.student.management.model.FullTimeProfessor;
import com.student.management.model.PartTimeProfessor;

public interface ProfessorService {
	
	Optional<FullTimeProfessor> getFullTimeProfessorbyId(int id);
	List<FullTimeProfessor> getAllFullTimeProfessors();
	FullTimeProfessor addFullTimeProfessor(FullTimeProfessor professor);
	Optional<FullTimeProfessor> updateFullTimeSalaryById(int id,BigDecimal salary);
	
	Optional<PartTimeProfessor> getPartTimeProfessorbyId(int id);
	List<PartTimeProfessor> getAllPartTimeProfessors();
	PartTimeProfessor addPartTimeProfessor(PartTimeProfessor professor);
	Optional<PartTimeProfessor> updatePartTimeSalaryById(int id,BigDecimal salary);

}
