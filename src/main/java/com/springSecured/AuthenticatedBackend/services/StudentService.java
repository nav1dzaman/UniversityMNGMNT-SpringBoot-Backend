package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.entities.Role;
import com.springSecured.AuthenticatedBackend.entities.Student;
import com.springSecured.AuthenticatedBackend.entities.User;
import com.springSecured.AuthenticatedBackend.repository.RoleRepository;
import com.springSecured.AuthenticatedBackend.repository.StudentRepository;
import com.springSecured.AuthenticatedBackend.repository.UserRepository;
import com.springSecured.AuthenticatedBackend.request.StudentRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

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
               student.setStudent_email(body.getStudent_email());
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



}
