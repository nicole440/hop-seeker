package com.breweryfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery {
    @JsonProperty("id")
    private String breweryId;
    @JsonProperty("name")
    private String breweryName;
    @JsonProperty("address_1")
    private String breweryStreetAddress;
    @JsonProperty("city")
    private String breweryCity;
    @JsonProperty("postal_code")
    private String breweryZipCode;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("website_url")
    private String breweryWebsite;

    public Brewery(String breweryId, String breweryName, String breweryStreetAddress, String breweryCity, String breweryZipCode, String latitude, String longitude, String breweryWebsite) {
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.breweryStreetAddress = breweryStreetAddress;
        this.breweryCity = breweryCity;
        this.breweryZipCode = breweryZipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.breweryWebsite = breweryWebsite;
    }

    public Brewery() {

    }

    public String getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(String breweryId) {
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBreweryWebsite() {
        return breweryWebsite;
    }

    public void setBreweryWebsite(String breweryWebsite) {
        this.breweryWebsite = breweryWebsite;
    }
}
