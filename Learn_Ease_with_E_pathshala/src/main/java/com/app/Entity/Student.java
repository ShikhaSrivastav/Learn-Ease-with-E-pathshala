package com.app.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
//@Getter
//@Setter
//@ToString
@Table(name = "Student_info")
public class Student extends BaseEntity {

	@Column(name = "Student_name")
	private String name;
	@Column(name = "Email", length = 30)
	private String email;
	@Column(name = "password", unique = true, length = 20)
	private String password;
	@Transient
	private String confirmPassword;
	@Column(name = "Date_of_birth")
	private LocalDate date;

	@OneToOne
	private Enrollment enrollment;

	@OneToOne
	private Billing billing;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER, mappedBy = "students")
	private List<Course> course = new ArrayList<>();

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + getId() + ", email=" + email + ", password=" + password + ", date=" + date
				+ "]";
	}

	public Student(String name, String email, String password, String confirmPassword, LocalDate date) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}