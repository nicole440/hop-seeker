package com.example.BreweryFinder.models;

public class LoginResponseDto {

    private String token;
    private com.example.BreweryFinder.models.User user;

    public LoginResponseDto(String token, com.example.BreweryFinder.models.User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    void setToken(String token) {
        this.token = token;
    }

    public com.example.BreweryFinder.models.User getUser() {
        return user;
    }

    public void setUser(com.example.BreweryFinder.models.User user) {
        this.user = user;
    }
}
