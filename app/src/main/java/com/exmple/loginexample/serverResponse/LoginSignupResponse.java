package com.exmple.loginexample.serverResponse;

public class LoginSignupResponse {
    private Boolean status;
    private String token;

    public LoginSignupResponse(Boolean status, String token) {
        this.status = status;
        this.token = token;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
