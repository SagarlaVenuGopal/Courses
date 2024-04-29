package com.example.Project.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Project.Util.ResponseStruture;
import com.example.Project.dao.CoursesDao;
import com.example.Project.dto.Courses;
import com.example.Project.exception.CoursesIdNotFound;

@Service
public class CoursesService {

	@Autowired
	CoursesDao coursesDao;

	public ResponseEntity<ResponseStruture<Courses>> saveCourse(Courses courses) {

		ResponseStruture<Courses> responseStruture = new ResponseStruture<Courses>();
		responseStruture.setStatus(HttpStatus.CREATED.value());

		responseStruture.setMesaage("Succesfully Courses inserted into DB");

		responseStruture.setData(coursesDao.saveCourse(courses));

		return new ResponseEntity<ResponseStruture<Courses>>(responseStruture, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStruture<Courses>> fetchCoursesById(int id) {

		Courses courses = coursesDao.fetchCoursesById(id);
		if (courses != null) {
			ResponseStruture<Courses> responseStruture = new ResponseStruture<Courses>();

			responseStruture.setStatus(HttpStatus.FOUND.value());

			responseStruture.setMesaage("Succesfully Courses fetched from DB");

			responseStruture.setData(coursesDao.fetchCoursesById(id));

			return new ResponseEntity<ResponseStruture<Courses>>(responseStruture, HttpStatus.FOUND);
		} else {
			throw new CoursesIdNotFound();
		}

	}

//	public List<Courses> searchCoursesByNameAndActiveStatus(String courseName, boolean isActive) {
//		return coursesDao.searchCoursesByNameAndActiveStatus(courseName, isActive);
//	}
	
	public ResponseEntity<ResponseStruture<Courses>> fetchBycourseName(String courseName) {
		Courses courses=coursesDao.fetchByCourseName(courseName);
		if(courses!=null) {
		ResponseStruture<Courses> responseStruture = new ResponseStruture<Courses>();

		responseStruture.setStatus(HttpStatus.FOUND.value());

		responseStruture.setMesaage("Succesfully Courses fetched from DB");

		responseStruture.setData(coursesDao.fetchByCourseName(courseName));

		return new ResponseEntity<ResponseStruture<Courses>>(responseStruture, HttpStatus.FOUND);
		}
		else {
			throw new  CoursesIdNotFound();
		}

        
	}
}
