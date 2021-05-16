package com.student.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name="STUDENT_SEQ",sequenceName = "student_sequence",allocationSize = 1)
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ")
	private int studentId;
	
	private String studentName;
	
	@Embedded
	private Address address;
	
	@OneToOne
	private AadharId aadharId;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name="STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID" ))
	private List<Course> courses=new ArrayList<>();
	
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, Address address, AadharId aadharId, List<Course> courses) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
		this.aadharId = aadharId;
		this.courses = courses;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public AadharId getAadharId() {
		return aadharId;
	}
	public void setAadharId(AadharId aadharId) {
		this.aadharId = aadharId;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address
				+ ", aadharId=" + aadharId + ", courses=" + courses + "]";
	}

}
