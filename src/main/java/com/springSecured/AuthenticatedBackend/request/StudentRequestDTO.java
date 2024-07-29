package com.springSecured.AuthenticatedBackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

//    private Long student_id;
    private String student_email;
    private String student_name ;
    private String password;
    private String student_address;


}
