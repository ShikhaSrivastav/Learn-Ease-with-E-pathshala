package com.app.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString

public class Course extends BaseEntity {

	@Column(name = "Course_Name")
	private String courseName;
	
	@Column(name = "Course_Fees")
	private long courseFees;

	@OneToMany(mappedBy = "course")
	private List<Lecture> lecture = new ArrayList<>();

	@OneToOne
	private Tutor tutor;

	@OneToOne
	private Billing billing;

	@OneToOne
	private Enrollment enrollment;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course", 
	joinColumns = @JoinColumn(name = "Course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Student_id", referencedColumnName = "id"))
	private List<Student> students = new ArrayList<>();

	public Course() {
		super();
	}

	public Course(String courseName, long courseFees) {
		super();
		this.courseName = courseName;
		this.courseFees = courseFees;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(long courseFees) {
		this.courseFees = courseFees;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + getId() + courseName + ", courseFees=" + courseFees + "]";
	}

}
