package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.dto.RegisterResponse;
import com.springSecured.AuthenticatedBackend.dto.RegistrationDTO;
import com.springSecured.AuthenticatedBackend.entities.ApplicationUser;
import com.springSecured.AuthenticatedBackend.dto.LoginResponseDTO;
import com.springSecured.AuthenticatedBackend.entities.Role;
import com.springSecured.AuthenticatedBackend.repository.RoleRepository;
import com.springSecured.AuthenticatedBackend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public RegisterResponse registerUser(RegistrationDTO body){

        RegisterResponse registerResponses = new RegisterResponse();

        if(userRepository.existsByEmail(body.getEmail())){
//          //  throw new UserAlreadyExistsException(email + " already exists");
            registerResponses.setMessage("failed");

        }
        else{
            String encodedPassword = passwordEncoder.encode(body.getPassword());
            Role userRole = roleRepository.findByAuthority("USER").get();
            registerResponses.setMessage("ok");
            Set<Role> authorities = new HashSet<>();
            authorities.add(userRole);
            userRepository.save(new ApplicationUser(0, body.getUsername(), body.getEmail(), encodedPassword, authorities));

        }

        return registerResponses;
    }

    public LoginResponseDTO loginUser(RegistrationDTO body){

        try{
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword())
            );

            String token = tokenService.generateJwt(auth,body.getEmail());
 //userRepository.findByEmail(body.getEmail()).get(),
            return new LoginResponseDTO( token);

        } catch(AuthenticationException e){
            return new LoginResponseDTO("");
        }
    }

}
