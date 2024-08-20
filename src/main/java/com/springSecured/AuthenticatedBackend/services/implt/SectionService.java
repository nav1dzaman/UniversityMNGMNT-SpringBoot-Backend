package com.springSecured.AuthenticatedBackend.services.implt;

import com.springSecured.AuthenticatedBackend.dto.SectionDTO;
import com.springSecured.AuthenticatedBackend.dto.SectionResponseDTO;
import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.entities.Course;
import com.springSecured.AuthenticatedBackend.entities.Faculty;
import com.springSecured.AuthenticatedBackend.entities.Section;
import com.springSecured.AuthenticatedBackend.entities.Session;
import com.springSecured.AuthenticatedBackend.repository.CourseRepository;
import com.springSecured.AuthenticatedBackend.repository.FacultyRepository;
import com.springSecured.AuthenticatedBackend.repository.SectionRepository;
import com.springSecured.AuthenticatedBackend.repository.SessionRepository;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.SectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService implements SectionServices {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public RegisterResponse createSection(SectionDTO body) {
        RegisterResponse registerResponse=new RegisterResponse();

        try{
            if(sectionRepository.existsBySectioncode (body.getSectioncode())){
//          //  throw new UserAlreadyExistsException(email + " already exists");
                registerResponse.setMessage("exist");
            }
            else{

                Section section=new Section();

                Course course = courseRepository.findById(body.getFk_course_id())
                        .orElseThrow(() -> new RuntimeException("Course not found"));
                Faculty faculty = facultyRepository.findById(body.getFk_faculty_id())
                        .orElseThrow(() -> new RuntimeException("Faculty not found"));
                Session session = sessionRepository.findById(body.getFk_session_id())
                        .orElseThrow(() -> new RuntimeException("Session not found"));

                section.setFaculty(faculty);
                section.setCourse(course);
                section.setSession(session);
                section.setSectioncode(body.getSectioncode());

                Section temp_course=sectionRepository.save(section);
                registerResponse.setMessage("ok");
            }
        }catch(Exception e){
            System.out.println(e);
            registerResponse.setMessage("internal error");
        }
        return registerResponse;
    }

    @Override
    public List<SectionResponseDTO> getAllSection() {
        List <Section> sections=sectionRepository.findAll();

        List<SectionResponseDTO> responses = new ArrayList<>();
        for (Section everyone : sections){
            SectionResponseDTO response =new SectionResponseDTO();

          response.setSectioncode(everyone.getSectioncode());
          response.setCourseCode(everyone.getCourse().getCoursecode());
          response.setFacultyName(everyone.getFaculty().getFaculty_name());
          response.setSessionName(everyone.getSession().getSessioncode());
          response.setSection_id(everyone.getSectionId());
            responses.add(response);
        }
        return responses;
    }
}
