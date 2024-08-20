package com.springSecured.AuthenticatedBackend.controllers;


import com.springSecured.AuthenticatedBackend.request.StudentRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.StudentResponse;
import com.springSecured.AuthenticatedBackend.services.implt.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

 StudentService studentService;

 @PostMapping("/register-student")
 @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse registerStudent(@RequestBody StudentRequestDTO body){
     System.out.println(body.getStudent_email());
        return studentService.registerStudent(body);
    }

    @GetMapping("/get-students")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
     List <StudentResponse> response=studentService.getAllStudents();
     return ResponseEntity.ok(response);
    }
}
