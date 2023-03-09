package com.app.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EnrollmentDto;
import com.app.dto.EnrollmentDtotoEntity;
import com.app.entity.Enrollment;
import com.app.repository.EnrollmentDao;

@Service
public class EnrollmentService {
	@Autowired
	private EnrollmentDao enrollmentdao;
	@Autowired
	private EnrollmentDtotoEntity converter;
//	@Autowired
//	private Enrollment enrollment;
//	@Autowired
//	private UserDao userdao;
//	
//	public Map<String,Object> addEnrollment(Enrollment enrollment ){
//		System.out.println(enrollment.toString()); 
//		Object u1= enrollmentdao.findById(enrollment.getUser());
//		((EnrollmentService) u1).addEnrollment(enrollment);
//		enrollment = enrollmentdao.save(enrollment);
//		
//		return Collections.singletonMap("insertedId", enrollment.getCourseid());
//	}
	
	public boolean addEnrollment(Enrollment enrollment) {
		if (enrollmentdao.save(enrollment)!=null)
			return true;
		return false;
	}
	
	
//	public List<Enrollment> findAllenrollment(){
//		List<Enrollment> enrollmentList =enrollmentdao.findAllEnrollmnet();
//		return enrollmentList;
//
//	}
	public List<EnrollmentDto> findAllEnrollment(){
		List<Enrollment> enrollmentList =enrollmentdao.findAll();
		return enrollmentList.stream()
				.map(enrollment -> converter.toEnrollmentDto(enrollment))
				.collect(Collectors.toList());
	}
	
	public Enrollment findenrollmentById(int enrollmentId) {
		Enrollment enrollment = enrollmentdao.findByenrollmentid(enrollmentId);
		return enrollment;
	}
	public Map<String,Object> addEnrollment(EnrollmentDto enroldto){
		Enrollment enrollment=converter.toEnrollmentEntity(enroldto);
		System.out.println(enrollment.toString());
		
		enrollment = enrollmentdao.save(enrollment);
		return Collections.singletonMap("insertedId", enrollment.getEnrollmentid());
	}
	
	
	public Object findCourseByEnrollmentById(int enrollmentId) {
		Object enrollment = enrollmentdao.findCourseEnrollmentID(enrollmentId);
		return enrollment;
	}
	
	
}
	