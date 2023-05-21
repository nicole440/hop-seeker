package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;

import java.util.List;

public interface BreweryService {

    List<Brewery> getAllBreweries();
    List<Brewery> getBreweriesByName(String breweryName);
    List<Brewery> getBreweriesByCity(String city);
    List<Brewery> getBreweriesByZip(String zipCode);
    List<Brewery> getFavoritesByUserId(int userId);
    boolean addBrewery(Brewery newBrewery);
}
