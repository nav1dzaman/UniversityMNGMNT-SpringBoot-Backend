package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.dto.CourseDTO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;

import java.util.List;

public interface CourseServices {
  public RegisterResponse registerCourse(CourseDTO body);
  List<CourseDTO> getAllCourse();

}
