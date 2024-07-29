package com.springSecured.AuthenticatedBackend.response;

import com.springSecured.AuthenticatedBackend.entities.User;

public class LoginResponse {
    private User user;
    private String jwt;

    public LoginResponse(){
        super();
    }

    public LoginResponse(String jwt){

        this.jwt = jwt;
    }



    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}
