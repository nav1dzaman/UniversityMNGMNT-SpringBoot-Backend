package com.springSecured.AuthenticatedBackend.controllers;

import com.springSecured.AuthenticatedBackend.dto.LoginDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.LoginResponse;
import com.springSecured.AuthenticatedBackend.dto.UserRegistrationDTO;
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
    public RegisterResponse registerUser(@RequestBody UserRegistrationDTO body){
        return authenticationService.registerUser(body);
    }
    
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginDTO body){
        return authenticationService.loginUser(body);
    }
}   
