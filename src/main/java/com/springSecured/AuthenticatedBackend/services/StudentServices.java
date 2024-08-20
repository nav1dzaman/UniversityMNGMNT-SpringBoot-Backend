package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.entities.Student;
import com.springSecured.AuthenticatedBackend.request.StudentRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.StudentResponse;

import java.util.List;

public interface StudentServices {

    RegisterResponse registerStudent(StudentRequestDTO body);
    List<StudentResponse> getAllStudents();

}
