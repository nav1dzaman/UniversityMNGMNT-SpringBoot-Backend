package com.springSecured.AuthenticatedBackend.dto;


import com.springSecured.AuthenticatedBackend.entities.Section;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
    private Long studentId;
    private Long sectionId;
    private double grade;
}
