package com.example.BreweryFinder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private int id;
    @NotNull
    private LocalDate dateOfBirth;
    @NotBlank
    private String username;
    @JsonIgnore // prevent from being sent to client
    private String password;
    @JsonIgnore
    private boolean activated;
    private Set<com.example.BreweryFinder.models.Authority> authorities = new HashSet<>();

    private int LEGAL_DRINKING_AGE_USA = 21;

    public User() { }

    public User(int id, LocalDate dateOfBirth, String username, String password, String authorities) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
        if(authorities != null) this.setAuthorities(authorities);
        this.activated = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(dateOfBirth, now);
        int age = period.getYears();
        if (age >= LEGAL_DRINKING_AGE_USA) {
            this.dateOfBirth = dateOfBirth;
        } else dateOfBirth = null;
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Set<com.example.BreweryFinder.models.Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<com.example.BreweryFinder.models.Authority> authorities) {
        this.authorities = authorities;
    }

    public void setAuthorities(String authorities) {
        String[] roles = authorities.split(",");
        for(String role : roles) {
            this.authorities.add(new com.example.BreweryFinder.models.Authority("ROLE_" + role));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                activated == user.activated &&
                Objects.equals(dateOfBirth, user.dateOfBirth) && // added DOB
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, username, password, activated, authorities); // added DOB
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dateOfBirth=" + dateOfBirth + // added DOB
                ", username=" + username + '\'' +
                ", activated=" + activated +
                ", authorities=" + authorities +
                '}';
    }

}
