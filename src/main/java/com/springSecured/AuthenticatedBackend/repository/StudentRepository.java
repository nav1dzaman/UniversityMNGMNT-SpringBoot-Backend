package com.springSecured.AuthenticatedBackend.repository;

import com.springSecured.AuthenticatedBackend.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
