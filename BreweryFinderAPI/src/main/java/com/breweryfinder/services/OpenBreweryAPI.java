package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@CrossOrigin
public class OpenBreweryAPI {

    private final RestTemplate restTemplate;
    private static final String EXTERNAL_API_URL = "https://api.openbrewerydb.org/v1/breweries";

    public OpenBreweryAPI() {
        this.restTemplate = new RestTemplate();
    }

    public List<Brewery> getBreweriesByName(String breweryName) {
        ResponseEntity<Brewery[]> response = restTemplate.exchange(EXTERNAL_API_URL + "?by_name=" + breweryName + "&by_state=pennsylvania&per_page=200", HttpMethod.GET, null, Brewery[].class);
        Brewery[] breweries = response.getBody();
        return Arrays.asList(breweries != null ? breweries : new Brewery[0]);
    }

    public List<Brewery> getBreweriesByCity(String city) {
        ResponseEntity<Brewery[]> response = restTemplate.exchange(EXTERNAL_API_URL + "?by_city=" + city + "&by_state=pennsylvania&per_page=200", HttpMethod.GET, null, Brewery[].class);
        Brewery[] breweries = response.getBody();
        return Arrays.asList(breweries != null ? breweries : new Brewery[0]);
    }

    public List<Brewery> getBreweriesByZip(String zipCode) {
        ResponseEntity<Brewery[]> response = restTemplate.exchange(EXTERNAL_API_URL + "?by_postal=" + zipCode + "&by_state=pennsylvania&per_page=200", HttpMethod.GET, null, Brewery[].class);
        Brewery[] breweries = response.getBody();
        return Arrays.asList(breweries != null ? breweries : new Brewery[0]);
    }
}
