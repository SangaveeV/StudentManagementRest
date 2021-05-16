package com.student.management.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name="COURSE_SEQ",sequenceName = "course_sequence",allocationSize = 1)
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQ")
	private int id;
	private String name;
	
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private List<Reviews> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students=new ArrayList<>();
	
	public Course() {
		super();
	}

	public Course(int id, String name, List<Reviews> reviews, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.reviews = reviews;
		this.students = students;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", reviews=" + reviews + ", students=" + students + "]";
	}
}
