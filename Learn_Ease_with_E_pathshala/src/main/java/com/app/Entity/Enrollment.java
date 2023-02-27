package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Enrollment extends BaseEntity{

	@OneToOne
	
	private Course course;
	
	@OneToOne

	private Student student;
	
	@OneToOne
	
	private Billing billing;

	public Enrollment() {
		super();
	}
	
}
