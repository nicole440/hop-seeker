package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestBreweryService implements BreweryService {

    private static final String API_BASE_URL = "https://api.openbrewerydb.org/v1/breweries";
    RestTemplate restTemplate = new RestTemplate();

    public RestBreweryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Brewery> getAllBreweries() {
        return null;
    }

    @Override
    public List<Brewery> getBreweriesByName(String breweryName) {
        return null;
    }

    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        return null;
    }

    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        return null;
    }
}
