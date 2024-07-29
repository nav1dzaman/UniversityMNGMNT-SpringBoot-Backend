package com.springSecured.AuthenticatedBackend.dto;

public class UserRegistrationDTO {
    private String username;
    private String email;
    private String password;


    public UserRegistrationDTO(){
        super();
    }

    public UserRegistrationDTO(String username, String email, String password){
        super();
        this.username = username;
        this.email=email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String toString(){
        return "Registration info: username: " + this.username + " password: " + this.password;
    }
}
