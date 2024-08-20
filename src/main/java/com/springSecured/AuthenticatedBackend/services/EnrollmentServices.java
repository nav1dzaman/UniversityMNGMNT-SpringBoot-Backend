package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.dto.EnrollmentDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;

public interface EnrollmentServices {
    public RegisterResponse makeEnrollment(EnrollmentDTO body);

}
