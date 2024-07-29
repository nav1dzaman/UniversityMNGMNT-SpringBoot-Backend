package com.springSecured.AuthenticatedBackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    @Column(nullable = false,unique = true)
    private String student_email;
    @Column(nullable = false)
    private String student_name ;
    private String student_address;
    private double cgpa;
    private double credit_completed;

}
