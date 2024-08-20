package com.springSecured.AuthenticatedBackend.repository;

import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.entities.Session;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {

             boolean existsBySessioncode(String sessioncode);

}
