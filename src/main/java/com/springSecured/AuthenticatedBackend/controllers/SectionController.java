package com.springSecured.AuthenticatedBackend.controllers;

import com.springSecured.AuthenticatedBackend.dto.SectionDTO;
import com.springSecured.AuthenticatedBackend.dto.SectionResponseDTO;
import com.springSecured.AuthenticatedBackend.dto.SessionDTIO;
import com.springSecured.AuthenticatedBackend.response.RegisterResponse;
import com.springSecured.AuthenticatedBackend.services.implt.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/section")
@CrossOrigin("*")
public class SectionController {

    private SectionService sectionService;


    @PostMapping("/add-section")
    @PreAuthorize("hasRole('ADMIN')")
    public RegisterResponse createSection(@RequestBody SectionDTO body){
        return  sectionService.createSection(body);
    }

    @GetMapping("/get-sections")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<SectionResponseDTO>> getAllSections(){
        List <SectionResponseDTO> responses=sectionService.getAllSection();
        return ResponseEntity.ok(responses);
    }




}
