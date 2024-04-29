package com.example.Project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Project.dto.Courses;

public interface CoursesRepo extends JpaRepository<Courses, Integer> {
	@Query("SELECT c FROM Courses c WHERE c.courseName = :courseName")
	Optional<Courses> findByName(String courseName);

}
