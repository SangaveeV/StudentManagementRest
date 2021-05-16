package com.student.management.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.model.FullTimeProfessor;
import com.student.management.model.PartTimeProfessor;
import com.student.management.repository.FullTimeProfessorRepository;
import com.student.management.repository.PartTimeProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	FullTimeProfessorRepository fullTimeProfessorRepository;
	
	@Autowired
	PartTimeProfessorRepository partTimeProfessorRepository;

	@Override
	public Optional<FullTimeProfessor> getFullTimeProfessorbyId(int id) {
		return this.fullTimeProfessorRepository.findById(id);
	}

	@Override
	public Optional<PartTimeProfessor> getPartTimeProfessorbyId(int id) {
		return partTimeProfessorRepository.findById(id);
	}

	@Override
	public List<FullTimeProfessor> getAllFullTimeProfessors() {
		return fullTimeProfessorRepository.findAllFullTimeProfessor();
	}

	@Override
	public FullTimeProfessor addFullTimeProfessor(FullTimeProfessor professor) {
		return fullTimeProfessorRepository.save(professor);
	}

	@Override
	public List<PartTimeProfessor> getAllPartTimeProfessors() {
		return partTimeProfessorRepository.findAllPartTimeProfessor();
	}

	@Override
	public PartTimeProfessor addPartTimeProfessor(PartTimeProfessor professor) {
		return partTimeProfessorRepository.save(professor);
	}

	@Override
	public Optional<FullTimeProfessor> updateFullTimeSalaryById(int id, BigDecimal salary) {
		fullTimeProfessorRepository.updateFullTimeProfessorSalaryById(id, salary);
		return fullTimeProfessorRepository.findById(id);
	}

	@Override
	public Optional<PartTimeProfessor> updatePartTimeSalaryById(int id, BigDecimal salary) {
		partTimeProfessorRepository.updatePartTimeProfessorSalaryById(id, salary);
		return partTimeProfessorRepository.findById(id);
	}

}
