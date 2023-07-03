package com.breweryfinder.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery {
    @JsonProperty("id")
    private String breweryId;
    @JsonProperty("name")
    private String breweryName;
    @JsonProperty("address_1")
    private String streetAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postal_code")
    private String zipCode;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("website_url")
    private String website;

    public Brewery(String breweryId, String breweryName, String breweryStreetAddress, String breweryCity, String breweryZipCode, String latitude, String longitude, String breweryWebsite) {
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.streetAddress = breweryStreetAddress;
        this.city = breweryCity;
        this.zipCode = breweryZipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.website = breweryWebsite;
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
        return website;
    }

    public void setBreweryWebsite(String breweryWebsite) {
        this.website = breweryWebsite;
    }
}
