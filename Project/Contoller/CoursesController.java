package com.example.Project.Contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Service.CoursesService;
import com.example.Project.Util.ResponseStruture;
import com.example.Project.dto.Courses;

@RestController
public class CoursesController {

	@Autowired
	CoursesService coursesService;

	@PostMapping("/saveCourse")
	public ResponseEntity<ResponseStruture<Courses>> saveCourse(@RequestBody Courses courses) {

		return coursesService.saveCourse(courses);
	}

	@GetMapping("/fetchCoursesById")
	public ResponseEntity<ResponseStruture<Courses>> fetchCoursesById(int id) {
		return coursesService.fetchCoursesById(id);
	}

//	@GetMapping("/searchCoursesByNameAndActiveStatus")
//	public List<Courses> searchCoursesByNameAndActiveStatus(String courseName, boolean isActive) {
//		return coursesService.searchCoursesByNameAndActiveStatus(courseName, isActive);
//	}
	
	@GetMapping("/fetchByCourseName")
	public ResponseEntity<ResponseStruture<Courses>> fetchByCourseName(String courseName) {
    	
		return coursesService.fetchBycourseName(courseName);
	}
}
