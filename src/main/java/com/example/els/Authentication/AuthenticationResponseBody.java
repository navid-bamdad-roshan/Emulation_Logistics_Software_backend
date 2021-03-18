package com.example.els.Authentication;

public class AuthenticationResponseBody {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public AuthenticationResponseBody(String jwt) {
        this.jwt = jwt;
    }
}
