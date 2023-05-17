package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface BreweryService {

    RestTemplate restTemplate = new RestTemplate();

    List<Brewery> getAllBreweries();
    List<Brewery> getBreweriesByName(String breweryName);
    List<Brewery> getBreweriesByCity(String city);
    List<Brewery> getBreweriesByZip(String zipCode);
    List<Brewery> searchBreweries(String searchTerm);
}
