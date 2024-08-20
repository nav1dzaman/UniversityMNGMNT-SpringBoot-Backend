package com.springSecured.AuthenticatedBackend.controllers;


import com.springSecured.AuthenticatedBackend.dto.EnrollmentDTO;
import com.springSecured.AuthenticatedBackend.dto.SectionDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.implt.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/enrollment")
@CrossOrigin("*")
public class EnrollmentController {

    private EnrollmentService enrollmentService;

    @PostMapping("/enroll-student")
    @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse createEnrollment(@RequestBody EnrollmentDTO body){
        return  enrollmentService.makeEnrollment(body);
    }
}
