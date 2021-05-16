package com.student.management.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="AADHAR_SEQ",sequenceName = "aadhar_sequence",allocationSize = 1)
public class AadharId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AADHAR_SEQ")
	private int id;
	private String aadharNumber;
	
	@OneToOne(mappedBy = "aadharId")
	@JsonIgnore
	private Student student;

	public AadharId() {
		super();
	}

	public AadharId(int id, String aadharNumber, Student student) {
		super();
		this.id = id;
		this.aadharNumber = aadharNumber;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "AadharID [id=" + id + ", AadharNumber=" + aadharNumber + ", student=" + student + "]";
	}
	
}
