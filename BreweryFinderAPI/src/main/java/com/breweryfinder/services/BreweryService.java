package com.breweryfinder.services;

import com.breweryfinder.models.Brewery;

import java.util.List;

public interface BreweryService {

    List<Brewery> getBreweriesByName(String breweryName);
    List<Brewery> getBreweriesByCity(String city);
    List<Brewery> getBreweriesByZip(String zipCode);
    List<Brewery> getFavoritesByUserId(int userId);
    void saveBreweries(List<Brewery> breweryList);
    boolean addBrewery(Brewery newBrewery);
}
