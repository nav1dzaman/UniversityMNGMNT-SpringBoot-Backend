package com.springSecured.AuthenticatedBackend.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private Long student_id;
    private String student_email;
    private String student_name ;
    private String student_address;
    private double cgpa;
    private double credit_completed;
}
