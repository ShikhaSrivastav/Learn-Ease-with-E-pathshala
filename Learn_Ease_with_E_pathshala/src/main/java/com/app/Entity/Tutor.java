package com.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tutor extends BaseEntity{

	@Column(name = "Name")
	private String tutorName;
	@Column(name = "Email" ,length = 30)
	private String email;
	@Column(name = "password",unique=true,length = 20)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(name = "Specialization")
	private String specialization;
	
	@OneToOne
	private Course course;
	
	public Tutor() {
		super();
	}
	public Tutor(String tutorName, String email, String password, String confirmPassword, String specialization) {
		super();
		this.tutorName = tutorName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Tutor [tutorName=" + tutorName +getId()+ ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", specialization=" + specialization + "]";
	}
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
	
}
