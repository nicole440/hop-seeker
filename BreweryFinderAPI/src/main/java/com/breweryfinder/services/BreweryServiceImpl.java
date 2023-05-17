package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/* This Service class will be utilized */
@Component
public class BreweryService {

    RestTemplate restTemplate = new RestTemplate();
    private static final String API_BASE_URL = "https://api.openbrewerydb.org/v1/breweries";

    public List<Brewery> getAllBreweries() {
        Brewery[] breweries = restTemplate.getForObject(API_BASE_URL, Brewery[].class);
        return Arrays.asList(breweries);
    }

    public List<Brewery> getBreweriesByName(String breweryName) {
        Brewery[] breweries = restTemplate.getForObject(API_BASE_URL + "?by_name=" + breweryName, Brewery[].class);
        return Arrays.asList(breweries);
    }

    public List<Brewery> getBreweriesByCity(String city) {
        Brewery[] breweries = restTemplate.getForObject(API_BASE_URL + "?by_city=" + city, Brewery[].class);
        return Arrays.asList(breweries);
    }

    public List<Brewery> getBreweriesByZip(String zipCode) {
        Brewery[] breweries = restTemplate.getForObject(API_BASE_URL + "?by_postal=" + zipCode, Brewery[].class);
        return Arrays.asList(breweries);
    }

    public List<Brewery> searchBreweries(String searchTerm) {
        Brewery[] breweries = restTemplate.getForObject(API_BASE_URL + "/search?query=" + searchTerm, Brewery[].class);
        return Arrays.asList(breweries);
    }
}
