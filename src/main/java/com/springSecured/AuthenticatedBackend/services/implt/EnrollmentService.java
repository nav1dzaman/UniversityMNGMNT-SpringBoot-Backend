package com.springSecured.AuthenticatedBackend.services.implt;

import com.springSecured.AuthenticatedBackend.dto.EnrollmentDTO;
import com.springSecured.AuthenticatedBackend.entities.*;
import com.springSecured.AuthenticatedBackend.repository.EnrollmentRepository;
import com.springSecured.AuthenticatedBackend.repository.SectionRepository;
import com.springSecured.AuthenticatedBackend.repository.StudentRepository;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.EnrollmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService implements EnrollmentServices {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Override
    public RegisterResponse makeEnrollment(EnrollmentDTO body) {

        RegisterResponse registerResponse=new RegisterResponse();

        try{

            Student student = studentRepository.findById(body.getStudentId()).
                    orElseThrow(() -> new RuntimeException("Faculty not found"));
            Section section = sectionRepository.findById(body.getSectionId())
                    .orElseThrow(() -> new RuntimeException("Session not found"));



            if(enrollmentRepository.existsByStudentAndSection (student,section)){
//          //  throw new UserAlreadyExistsException(email + " already exists");
                registerResponse.setMessage("exist");
            }
            else{

                Enrollment enrollment=new Enrollment();

                enrollment.setSection(section);
                enrollment.setStudent(student);
                enrollment.setGrade(body.getGrade());


                Enrollment temp_course=enrollmentRepository.save(enrollment);
                registerResponse.setMessage("ok");
            }
        }catch(Exception e){
            System.out.println(e);
            registerResponse.setMessage("internal error");
        }
        return registerResponse;
    }
}
