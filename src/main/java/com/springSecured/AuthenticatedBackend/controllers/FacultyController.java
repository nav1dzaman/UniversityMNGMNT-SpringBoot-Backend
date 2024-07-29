package com.springSecured.AuthenticatedBackend.controllers;

import com.springSecured.AuthenticatedBackend.request.FacultyRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    FacultyService facultyService;

    @PostMapping("/register-faculty")
    @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse registerFaculty(@RequestBody FacultyRequestDTO body){
         return facultyService.registerFaculty(body);
    }
}
