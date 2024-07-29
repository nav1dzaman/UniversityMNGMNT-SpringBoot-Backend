package com.springSecured.AuthenticatedBackend.services;


import com.springSecured.AuthenticatedBackend.entities.Faculty;
import com.springSecured.AuthenticatedBackend.entities.Role;
import com.springSecured.AuthenticatedBackend.entities.User;
import com.springSecured.AuthenticatedBackend.repository.FacultyRepository;
import com.springSecured.AuthenticatedBackend.repository.RoleRepository;
import com.springSecured.AuthenticatedBackend.repository.UserRepository;
import com.springSecured.AuthenticatedBackend.request.FacultyRequestDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UserRepository userRepository;
    private Role role;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterResponse registerFaculty(FacultyRequestDTO body){

        RegisterResponse registerResponse=new RegisterResponse();

        try{
            if(userRepository.existsByEmail(body.getFaculty_email())){
//          //  throw new UserAlreadyExistsException(email + " already exists");
                registerResponse.setMessage("exist");

            }
            else{

                Faculty faculty=new Faculty();

                faculty.setFaculty_email(body.getFaculty_email());
                faculty.setFaculty_name(body.getFaculty_name());

                Faculty temp_faculty=facultyRepository.save(faculty);

                String email_add = body.getFaculty_email();
                String userName = email_add.split("@")[0];



                String encodedPassword = passwordEncoder.encode(body.getPassword());
                Role userRole = roleRepository.findByAuthority("FACULTY").get();

                Set<Role> authorities = new HashSet<>();
                authorities.add(userRole);
                User user=new User();
                user.setUsername(userName);
                user.setEmail(body.getFaculty_email());
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
