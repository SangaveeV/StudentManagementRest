package com.student.management.model;

public class CourseStudentDto {

	private int courseId;
	private String courseName;
	private String studentName;
	private Address address;
	
	public CourseStudentDto() {
		super();
	}

	public CourseStudentDto(int courseId, String courseName, String studentName, Address address) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentName = studentName;
		this.address = address;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	@Override
	public String toString() {
		return "CourseStudentDto [courseId=" + courseId + ", courseName=" + courseName + ", studentName=" + studentName
				+ ", address=" + address + "]";
	}
	
}
