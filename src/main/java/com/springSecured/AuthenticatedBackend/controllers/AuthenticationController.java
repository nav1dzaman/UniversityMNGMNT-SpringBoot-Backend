package com.springSecured.AuthenticatedBackend.controllers;

import com.springSecured.AuthenticatedBackend.entities.ApplicationUser;
import com.springSecured.AuthenticatedBackend.dto.LoginResponseDTO;
import com.springSecured.AuthenticatedBackend.dto.RegistrationDTO;
import com.springSecured.AuthenticatedBackend.services.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}   
