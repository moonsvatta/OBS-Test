package com.obs.model;

public class Student {

	
	private String studentID;
	private String studentName;
	private int mark;
	private String department;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Student(String studentID, String studentName, int mark, String department) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.mark = mark;
		this.department = department;
	}
}
