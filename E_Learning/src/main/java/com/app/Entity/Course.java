package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Course extends BaseEntity {

	@Column(name = "Course Name")
	private String courseName;
	@Column(name = "Course Fees")
	private double courseFees;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student students;	
	
}
