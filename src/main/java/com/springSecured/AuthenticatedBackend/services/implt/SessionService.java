package com.springSecured.AuthenticatedBackend.services.implt;

import com.springSecured.AuthenticatedBackend.dto.CourseDTO;
import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.entities.Course;
import com.springSecured.AuthenticatedBackend.entities.Session;
import com.springSecured.AuthenticatedBackend.repository.CourseRepository;
import com.springSecured.AuthenticatedBackend.repository.SessionRepository;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.SessionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SessionService implements SessionServices {

    @Autowired
   private SessionRepository sessionRepository;


    @Override
    public RegisterResponse createSession(SessionDTIO body) {
        RegisterResponse registerResponse=new RegisterResponse();


        try{
            if(sessionRepository.existsBySessioncode(body.getSessioncode())){
//          //  throw new UserAlreadyExistsException(email + " already exists");
                registerResponse.setMessage("exist");
            }
            else{
                System.out.println("Hello");

                Session session=new Session();

                session.setSessioncode(body.getSessioncode());
                session.setStartingdate(body.getStartingdate());
                session.setEndingdate(body.getEndingdate());

                Session temp_course=sessionRepository.save(session);
                registerResponse.setMessage("ok");
            }
        }catch(Exception e){
            System.out.println(e);
            registerResponse.setMessage("internal error");
        }


        return registerResponse;

    }

    @Override
    public List<SessionDTIO> getAllSession() {

        List <Session> sessions=sessionRepository.findAll();

        List<SessionDTIO> responses = new ArrayList<>();
        for (Session everyone : sessions){
            SessionDTIO response =new SessionDTIO();

            response.setSessioncode(everyone.getSessioncode());
            response.setStartingdate(everyone.getStartingdate());
            response.setEndingdate(everyone.getEndingdate());
            response.setSession_id(everyone.getSessionid());
            responses.add(response);
        }
        return responses;

    }
}
