package com.student.management.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeStudent extends Student {
	
	private BigDecimal fees;

	public PartTimeStudent() {
		super();
	}

	public PartTimeStudent(BigDecimal fees) {
		super();
		this.fees = fees;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "PartTimeStudent [fees=" + fees + "]";
	}
	
}
