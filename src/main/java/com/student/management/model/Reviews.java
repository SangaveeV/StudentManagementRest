package com.student.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="REVIEW_SEQ",sequenceName = "preview_sequence",allocationSize = 1)
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEW_SEQ")
	private int id;
	private int rating;
	private String description;
	
	@ManyToOne
	private Course course;
	public Reviews() {
		super();
	}
	public Reviews(int id, int rating, String description, Course course) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", rating=" + rating + ", description=" + description + ", course=" + course + "]";
	}
		
}
