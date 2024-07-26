package com.springSecured.AuthenticatedBackend.dto;

public class RegisterResponse {

    String message;

    public RegisterResponse(){
        super();
    }

    public RegisterResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
