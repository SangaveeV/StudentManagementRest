package com.student.management.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeStudent extends Student {

	private BigDecimal fees;

	public FullTimeStudent(BigDecimal fees) {
		super();
		this.fees = fees;
	}
	public FullTimeStudent() {
		super();
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "FullTimeStudent [fees=" + fees + "]";
	}
	
}
