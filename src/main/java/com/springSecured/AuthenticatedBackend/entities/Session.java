package com.springSecured.AuthenticatedBackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionid;

    @Column( nullable = false, unique = true)
    private String sessioncode;

    @Column( nullable = false)
    private String startingdate;

    @Column( nullable = false)
    private String endingdate;
}
