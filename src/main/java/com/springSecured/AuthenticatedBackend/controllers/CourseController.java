package com.springSecured.AuthenticatedBackend.controllers;

import com.springSecured.AuthenticatedBackend.dto.CourseDTO;
import com.springSecured.AuthenticatedBackend.entities.Course;
import com.springSecured.AuthenticatedBackend.entities.Faculty;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.implt.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
@CrossOrigin("*")
public class CourseController {

  private  CourseService courseService;


  @PostMapping("/add-course")
  @PreAuthorize("hasRole('ADMIN')")
  public RegisterResponse registerCourse(@RequestBody CourseDTO body){

      return courseService.registerCourse(body);

  }

  @GetMapping("/get-courses")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<CourseDTO>> getAllCourse(){
    List <CourseDTO> responses=courseService.getAllCourse();
    return ResponseEntity.ok(responses);
  }
}
