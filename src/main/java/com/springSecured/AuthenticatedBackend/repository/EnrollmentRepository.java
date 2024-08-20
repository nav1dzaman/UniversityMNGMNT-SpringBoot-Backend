package com.springSecured.AuthenticatedBackend.repository;

import com.springSecured.AuthenticatedBackend.entities.Enrollment;
import com.springSecured.AuthenticatedBackend.entities.Section;
import com.springSecured.AuthenticatedBackend.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    boolean existsByStudentAndSection(Student student, Section section);
}
