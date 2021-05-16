package com.student.management.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeProfessor extends Professor {
	
	private BigDecimal hourlySalary;

	public PartTimeProfessor(BigDecimal hourlySalary) {
		super();
		this.hourlySalary = hourlySalary;
	}

	public PartTimeProfessor() {
		super();
	}

	public BigDecimal getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(BigDecimal hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [hourlySalary=" + hourlySalary + "]";
	}
	

}
