package com.springSecured.AuthenticatedBackend.controllers;


import com.springSecured.AuthenticatedBackend.dto.CourseDTO;
import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.SessionServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/session")
@CrossOrigin("*")
public class SessionController {

    private SessionServices sessionServices;

    @PostMapping("/add-session")
    @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse createSession(@RequestBody SessionDTIO body){
       return  sessionServices.createSession(body);
    }

    @GetMapping("/get-sessions")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<SessionDTIO>> getAllSession(){
        List <SessionDTIO> responses=sessionServices.getAllSession();
        return ResponseEntity.ok(responses);
    }
}
