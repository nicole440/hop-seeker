package com.breweryfinder.dao;

import com.breweryfinder.models.Brewery;

import java.util.List;

public interface BreweryDao {
    List<Brewery> getBreweries();
    List<Brewery> getBreweriesByName(String breweryName);
    List<Brewery> getBreweriesByCity(String city);
    List<Brewery> getBreweriesByZip(String zipCode);
    List<Brewery> getFavoritesByUserId(int currentUserId);
    boolean addNewBrewery(Brewery newBrewery);
}

