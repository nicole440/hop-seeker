package com.example.BreweryFinder.dao;

import com.example.BreweryFinder.models.Brewery;

import java.util.List;

public interface BreweryDao {
    List<Brewery> getAllBreweries();
    List<Brewery> searchBreweriesByName(String breweryName);
    List<Brewery> getBreweriesByCity(String city);
    List<Brewery> getBreweriesByZip(String zipCode);
}
