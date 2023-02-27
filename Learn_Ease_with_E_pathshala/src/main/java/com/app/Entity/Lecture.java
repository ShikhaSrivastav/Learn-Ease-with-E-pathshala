package com.app.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Lecture extends BaseEntity {

	    
	    private String title;
	    
	    private String description;
	    
   // Other fields
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "course_id", nullable = false)
	    private Course course;
	    
	    public Lecture() {
	        
	    }
	    
	    @Override
		public String toString() {
			return "Lecture [title=" + title + getId()+", description=" + description + "]";
		}


		public Lecture(String title, String description) {
	        this.title = title;
	        this.description = description;
	    }
	    
	    // Getters and setters
	
	    public String getTitle() {
	        return title;
	    }
	    
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	 
	    // Getters and setters
//	    
//	    public Course getCourse() {
//	        return course;
//	    }
//	    
//	    public void setCourse(Course course) {
//	        this.course = course;
//	    }
	}

