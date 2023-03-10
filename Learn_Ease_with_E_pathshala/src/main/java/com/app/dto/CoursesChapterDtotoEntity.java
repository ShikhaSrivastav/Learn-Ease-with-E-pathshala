package com.app.dto;

import org.springframework.stereotype.Component;

import com.app.entity.CourseChapter;
import com.app.entity.Courses;

@Component
public class CoursesChapterDtotoEntity {
	public CoursesChapterDto toCourseChapterDto(CourseChapter coursechapter) {
		CoursesChapterDto dto = new CoursesChapterDto();
		dto.setCourseChapterid(coursechapter.getCourseChapterid());
		dto.setChapterTitle(coursechapter.getChapterTitle());
		dto.setNumOfVideo(coursechapter.getNumOfVideo());

		dto.setCourseid(coursechapter.getCourses().getCourseid());
	
		return dto;
	}

	public CourseChapter toCourseChapterEntity(CoursesChapterDto dto) {
		CourseChapter coursechapter = new CourseChapter();
		coursechapter.setCourseChapterid(dto.getCourseChapterid());
		coursechapter.setChapterTitle(dto.getChapterTitle());
		coursechapter.setNumOfVideo(dto.getNumOfVideo());
//		coursechapter.setSlotNo(dto.getSlotNo());
		coursechapter.setCourses(new Courses(dto.getCourseid()));
		return coursechapter;		
	}

//	public CourseChapter toChapterContentDto(CourseChapterContentDto chapterDto) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
