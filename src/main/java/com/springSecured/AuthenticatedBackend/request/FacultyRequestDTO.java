package com.springSecured.AuthenticatedBackend.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyRequestDTO {


    private String faculty_name;
    private String faculty_email;
    private String password;


}
