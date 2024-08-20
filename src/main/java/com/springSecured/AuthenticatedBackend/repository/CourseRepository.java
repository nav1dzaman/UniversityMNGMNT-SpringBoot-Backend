package com.springSecured.AuthenticatedBackend.repository;

import com.springSecured.AuthenticatedBackend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

    boolean existsByCoursecode(String coursecode);

}
