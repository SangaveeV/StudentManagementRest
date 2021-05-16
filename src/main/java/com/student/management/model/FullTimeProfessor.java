package com.student.management.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeProfessor extends Professor {
	
	private BigDecimal monthlySalary;
	public FullTimeProfessor(BigDecimal monthlySalary) {
		super();
		this.monthlySalary = monthlySalary;
	}
	public FullTimeProfessor() {
		super();
	}
	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(BigDecimal monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + monthlySalary + "]";
	}
}
