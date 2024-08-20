package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.entities.Faculty;
import com.springSecured.AuthenticatedBackend.request.FacultyRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.StudentResponse;

import java.util.List;

public interface FacultyServices {
    public RegisterResponse registerFaculty(FacultyRequestDTO body);
    List<Faculty> getAllFaculty();
}
