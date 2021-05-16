package com.student.management.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.management.model.PartTimeProfessor;

@Repository
public interface PartTimeProfessorRepository extends ProfessorRepository{
	
	@Query("from PartTimeProfessor")
	List<PartTimeProfessor> findAllPartTimeProfessor();
	
	@Query("from PartTimeProfessor where id=:id")
	Optional<PartTimeProfessor> findById(int id);
	
	@Transactional
	@Modifying
	@Query("update PartTimeProfessor p set p.hourlySalary=:salary where p.id=:id")
	int updatePartTimeProfessorSalaryById(int id, BigDecimal salary);
}
