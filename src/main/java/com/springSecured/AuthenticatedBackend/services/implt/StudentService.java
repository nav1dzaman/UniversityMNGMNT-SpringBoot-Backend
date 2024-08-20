package com.springSecured.AuthenticatedBackend.services.implt;

import com.springSecured.AuthenticatedBackend.entities.Role;
import com.springSecured.AuthenticatedBackend.entities.Student;
import com.springSecured.AuthenticatedBackend.entities.User;
import com.springSecured.AuthenticatedBackend.repository.RoleRepository;
import com.springSecured.AuthenticatedBackend.repository.StudentRepository;
import com.springSecured.AuthenticatedBackend.repository.UserRepository;
import com.springSecured.AuthenticatedBackend.request.StudentRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.response.StudentResponse;
import com.springSecured.AuthenticatedBackend.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService implements StudentServices {

    @Autowired
    private StudentRepository studentRepository;
    private Student student;
    @Autowired
    private UserRepository userRepository;
    private Role role;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
   public RegisterResponse registerStudent(StudentRequestDTO body){

       RegisterResponse registerResponse=new RegisterResponse();

       try{
           if(userRepository.existsByEmail(body.getStudent_email())){
//          //  throw new UserAlreadyExistsException(email + " already exists");
               registerResponse.setMessage("exist");

           }
           else{

               Student student=new Student();

               student.setStudent_address(body.getStudent_address());
               student.setStudent_name(body.getStudent_name());
               student.setStudentemail(body.getStudent_email());
               student.setCgpa(0.0);
               student.setCredit_completed(0.0);

               Student temp_student=studentRepository.save(student);

               String email_add = body.getStudent_email();
               String userName = email_add.split("@")[0];



               String encodedPassword = passwordEncoder.encode(body.getPassword());
               Role userRole = roleRepository.findByAuthority("STUDENT").get();

               Set<Role> authorities = new HashSet<>();
               authorities.add(userRole);
               User user=new User();
               user.setUsername(userName);
               user.setEmail(body.getStudent_email());
               user.setPassword(encodedPassword);
               user.setAuthorities(authorities);
           User temp_user=userRepository.save(user);



               registerResponse.setMessage("ok");
           }
       }catch(Exception e){
           registerResponse.setMessage("internal error");
       }

       return registerResponse;
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        List<Student>  allStudents = studentRepository.findAll();


        List<StudentResponse> responses = new ArrayList<>();
        for (Student everyone : allStudents){
                 StudentResponse response =new StudentResponse();
                 response.setStudent_id(everyone.getStudent_id());
                 response.setStudent_name(everyone.getStudent_name());
                 response.setStudent_email(everyone.getStudentemail());
                 response.setStudent_address(everyone.getStudent_address());
                 response.setCgpa(everyone.getCgpa());
                 response.setCredit_completed(everyone.getCredit_completed());
                 responses.add(response);
        }
 return responses;

    }


}
