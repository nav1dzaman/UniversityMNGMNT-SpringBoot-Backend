package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;

import java.util.List;

public interface SessionServices {

    public RegisterResponse createSession(SessionDTIO body);
    List<SessionDTIO> getAllSession();

}
