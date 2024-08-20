package com.springSecured.AuthenticatedBackend.repository;

import com.springSecured.AuthenticatedBackend.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,Long> {

    boolean existsBySectioncode(String sectioncode);

}
