package com.springSecured.AuthenticatedBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionResponseDTO {
    private String sectioncode;
    private String facultyName;
    private String CourseCode;
    private String SessionName;
    private Long section_id;
}
