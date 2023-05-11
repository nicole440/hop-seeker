package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RestBreweryService implements BreweryService {

    private static final String API_BASE_URL = "https://api.openbrewerydb.org/v1/breweries";


    @Override
    public List<Brewery> getAllBreweries() {
        List<Brewery> breweryList = new ArrayList<>();
        breweryList = Collections.singletonList(restTemplate.getForObject(API_BASE_URL, Brewery.class));
        return breweryList;
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
