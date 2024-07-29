package com.springSecured.AuthenticatedBackend.controllers;


import com.springSecured.AuthenticatedBackend.request.StudentRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

 StudentService studentService;

 @PostMapping("/register-student")
 @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse registerStudent(@RequestBody StudentRequestDTO body){
//     System.out.println(body.getStudent_email());
        return studentService.registerStudent(body);
    }
}
