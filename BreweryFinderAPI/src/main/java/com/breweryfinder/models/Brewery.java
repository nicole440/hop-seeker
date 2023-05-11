package com.breweryfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery {
    private int breweryId;
    @JsonProperty
    private String breweryName;
    @JsonProperty
    private String breweryStreetAddress;
    @JsonProperty
    private String breweryCity;
    @JsonProperty
    private String breweryZipCode;
    @JsonProperty
    private String breweryWebsite;

    public Brewery(int breweryId, String breweryName, String breweryStreetAddress, String breweryCity, String breweryZipCode, String breweryWebsite) {
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.breweryStreetAddress = breweryStreetAddress;
        this.breweryCity = breweryCity;
        this.breweryZipCode = breweryZipCode;
        this.breweryWebsite = breweryWebsite;
    }

    public Brewery() {

    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getBreweryStreetAddress() {
        return breweryStreetAddress;
    }

    public void setBreweryStreetAddress(String breweryStreetAddress) {
        this.breweryStreetAddress = breweryStreetAddress;
    }

    public String getBreweryCity() {
        return breweryCity;
    }

    public void setBreweryCity(String breweryCity) {
        this.breweryCity = breweryCity;
    }

    public String getBreweryZipCode() {
        return breweryZipCode;
    }

    public void setBreweryZipCode(String breweryZipCode) {
        this.breweryZipCode = breweryZipCode;
    }

    public String getBreweryWebsite() {
        return breweryWebsite;
    }

    public void setBreweryWebsite(String breweryWebsite) {
        this.breweryWebsite = breweryWebsite;
    }
}
