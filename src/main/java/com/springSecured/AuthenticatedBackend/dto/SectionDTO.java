package com.springSecured.AuthenticatedBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionDTO {


    private String sectioncode;

    private Long fk_course_id;  // Assuming you only need the course ID, not the full Course object

    private Long fk_faculty_id; // Assuming you only need the faculty ID, not the full Faculty object

    private Long fk_session_id; // Assuming you only need the session ID, not the full Session object

}
