package com.springSecured.AuthenticatedBackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTIO {


    private String sessioncode;

    private String startingdate;

    private String endingdate;

    private long session_id;


}
