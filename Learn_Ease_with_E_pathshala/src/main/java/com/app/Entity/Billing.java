package com.app.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing extends BaseEntity {

	
	    @Column(name = "billing_date")
	    private LocalDate billingDate;

	    @Column(name = "billing_amount")
	    private double billingAmount;
	    
	    @Column(name = "discount")
	    private double discount;
	    
	    @Column(name = "final_amount")
	    private double finalAmount;
	    
//	    @ManyToOne
//	    @JoinColumn(name = "enrollment_id")
//	    private Enrollment enrollment;

	    @OneToOne
	   
	    private Student student;

	    @OneToOne
	  
	    private Course course;
	    
	    @OneToOne
	    private Enrollment enrollment;

		public Billing() {
			super();
		}

		public Billing(LocalDate billingDate, double billingAmount, double discount, double finalAmount) {
			super();
			this.billingDate = billingDate;
			this.billingAmount = billingAmount;
			this.discount = discount;
			this.finalAmount = finalAmount;
			
		}

		public LocalDate getBillingDate() {
			return billingDate;
		}

		public void setBillingDate(LocalDate billingDate) {
			this.billingDate = billingDate;
		}

		public double getBillingAmount() {
			return billingAmount;
		}

		public void setBillingAmount(double billingAmount) {
			this.billingAmount = billingAmount;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public double getFinalAmount() {
			return finalAmount;
		}

		public void setFinalAmount(double finalAmount) {
			this.finalAmount = finalAmount;
		}

//		public Enrollment getEnrollment() {
//			return enrollment;
//		}
//
//		public void setEnrollment(Enrollment enrollment) {
//			this.enrollment = enrollment;
//		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		@Override
		public String toString() {
			return "Billing [billingDate=" + billingDate + ", billingAmount=" + billingAmount + ", discount=" + discount
					+ ", finalAmount=" + finalAmount + "]";
		}
		
	

	    // Constructors, Getters and Setters
	

	}

