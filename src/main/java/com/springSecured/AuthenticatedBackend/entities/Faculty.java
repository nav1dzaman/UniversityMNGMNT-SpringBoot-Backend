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
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faculty_id;

    @Column(name = "faculty_name", nullable = false)
    private String faculty_name;

    @Column(name = "faculty_email", nullable = false, unique = true)
    private String faculty_email;



}
