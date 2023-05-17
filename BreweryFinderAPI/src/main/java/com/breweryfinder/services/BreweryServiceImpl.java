package com.breweryfinder.services;

import com.breweryfinder.dao.BreweryDao;
import com.breweryfinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**  Interacts with both ExternalAPIClient (to fetch breweries) and the BreweryDao (to perform database operations).*/
@Component
public class BreweryServiceImpl implements BreweryService {

    @Autowired
    BreweryDao breweryDao;
    @Autowired
    ExternalAPIClient externalAPIClient;

//    @Override
//    public List<Brewery> getAllBreweries() {
//        return breweryDao.getAllBreweries();
//    }

    @Override
    public List<Brewery> getBreweriesByName(String breweryName) {
        List<Brewery> breweryList = breweryDao.searchBreweriesByName(breweryName);
        if (breweryList.isEmpty()) {
            // If data not found in the database, fetch from the public API
            breweryList = externalAPIClient.getBreweriesByName(breweryName);

            // Store the fetched data in the database for future use
            breweryDao.saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        List<Brewery> breweryList = breweryDao.getBreweriesByCity(city);
        if (breweryList.isEmpty()) {
            // If data not found in the database, fetch from the public API
            breweryList = externalAPIClient.getBreweriesByCity(city);

            // Store the fetched data in the database for future use
            breweryDao.saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        List<Brewery> breweryList = breweryDao.getBreweriesByZip(zipCode);
        if (breweryList.isEmpty()) {
            // If data not found in the database, fetch from the public API
            breweryList = externalAPIClient.getBreweriesByZip(zipCode);

            // Store the fetched data in the database for future use
            breweryDao.saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getFavoritesByUserId(int userId) {
        return breweryDao.getFavoritesByUserId(userId);
    }

    @Override
    public boolean addBrewery(Brewery newBrewery) {
        return breweryDao.addNewBrewery(newBrewery);
    }
}
