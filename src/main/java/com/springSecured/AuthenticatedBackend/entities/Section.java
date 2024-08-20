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
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long sectionId;

    @Column(unique = true)
    private String sectioncode;





    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_course_id", nullable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_session_id", nullable = false)
    private Session session;

    // Constructors, getters, setters, and other fields as needed


}

