package com.example.els.authentication;

public class AuthenticationRequestBody{
    

    private String username;
    private String password;
    
    public AuthenticationRequestBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthenticationRequestBody() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
