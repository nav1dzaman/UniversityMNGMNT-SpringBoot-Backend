package com.springSecured.AuthenticatedBackend.services;

import com.springSecured.AuthenticatedBackend.dto.SectionDTO;
import com.springSecured.AuthenticatedBackend.dto.SectionResponseDTO;
import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.repository.SectionRepository;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;

import java.util.List;

public interface SectionServices {

  public RegisterResponse createSection(SectionDTO body);
  List<SectionResponseDTO> getAllSection();

}
