package com.student.management.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.management.model.FullTimeProfessor;

@Repository
public interface FullTimeProfessorRepository extends ProfessorRepository {

	@Query("from FullTimeProfessor")
	List<FullTimeProfessor> findAllFullTimeProfessor();
	
	@Query("from FullTimeProfessor where id=:id")
	Optional<FullTimeProfessor> findById(int id);
	
	@Transactional
	@Modifying
	@Query("update FullTimeProfessor p set p.monthlySalary=:salary where p.id=:id")
	int updateFullTimeProfessorSalaryById(int id, BigDecimal salary);
	
}
