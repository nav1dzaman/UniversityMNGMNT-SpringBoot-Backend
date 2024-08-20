package com.springSecured.AuthenticatedBackend.controllers;

import com.springSecured.AuthenticatedBackend.entities.Faculty;
import com.springSecured.AuthenticatedBackend.request.FacultyRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.StudentResponse;
import com.springSecured.AuthenticatedBackend.services.implt.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/faculty")
@CrossOrigin("*")
public class FacultyController {

    FacultyService facultyService;

    @PostMapping("/register-faculty")
    @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse registerFaculty(@RequestBody FacultyRequestDTO body){
         return facultyService.registerFaculty(body);
    }

    @GetMapping("/get-faculties")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        List <Faculty> response=facultyService.getAllFaculty();
        return ResponseEntity.ok(response);
    }
}
