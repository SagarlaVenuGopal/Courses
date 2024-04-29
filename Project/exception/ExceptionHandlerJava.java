package com.example.Project.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Project.Util.ResponseStruture;


@RestControllerAdvice
public class ExceptionHandlerJava {
	
	@ExceptionHandler(CoursesIdNotFound.class)
	public ResponseEntity<ResponseStruture<String>> CourseIdNotFound(CoursesIdNotFound coursesIdNotFound) {
		ResponseStruture<String> responseStruture = new ResponseStruture<String>();

		responseStruture.setStatus(HttpStatus.NOT_FOUND.value());

		responseStruture.setMesaage("CourseIdNotFound");
		return new ResponseEntity<ResponseStruture<String>>(responseStruture, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ClientsIdNotFound.class)
	public ResponseEntity<ResponseStruture<String>> ClientIdNotFound(ClientsIdNotFound clientIdNotFound){
		ResponseStruture<String> responseStruture=new ResponseStruture<String>();
		responseStruture.setStatus(HttpStatus.NOT_FOUND.value());
		responseStruture.setMesaage("ClientIdNotFound");
		return new ResponseEntity<ResponseStruture<String>>(responseStruture,HttpStatus.NOT_FOUND);
		
		
	}
	
	

}
 