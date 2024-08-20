package com.springSecured.AuthenticatedBackend.services.implt;

import com.springSecured.AuthenticatedBackend.dto.CourseDTO;
import com.springSecured.AuthenticatedBackend.entities.Course;
import com.springSecured.AuthenticatedBackend.entities.Student;
import com.springSecured.AuthenticatedBackend.repository.CourseRepository;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.StudentResponse;
import com.springSecured.AuthenticatedBackend.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements CourseServices {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public RegisterResponse registerCourse(CourseDTO body) {

        RegisterResponse registerResponse=new RegisterResponse();


        try{
            if(courseRepository.existsByCoursecode(body.getCoursecode())){
//          //  throw new UserAlreadyExistsException(email + " already exists");
                registerResponse.setMessage("exist");
            }
            else{

                Course course=new Course();

               course.setCoursecode(body.getCoursecode());
               course.setCourse_name(body.getCourse_name());

                Course temp_course=courseRepository.save(course);
                registerResponse.setMessage("ok");
            }
        }catch(Exception e){
            registerResponse.setMessage("internal error");
        }


        return registerResponse;
    }

    @Override
    public List<CourseDTO> getAllCourse() {

        List <Course> courses=courseRepository.findAll();

        List<CourseDTO> responses = new ArrayList<>();
        for (Course everyone : courses){
            CourseDTO response =new CourseDTO();
            response.setCourse_name(everyone.getCourse_name());
            response.setCoursecode(everyone.getCoursecode());
            response.setCourse_id(everyone.getCourse_id());
            responses.add(response);
        }
        return responses;


    }
}
