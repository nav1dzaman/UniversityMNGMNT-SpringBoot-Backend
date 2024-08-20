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
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_student_id", nullable = false)
    private Student student;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_section_id", nullable = false)
    private Section section;

    @Column(name = "grade")
    private double grade;

    // Constructors, getters, setters, and other fields as needed

}
