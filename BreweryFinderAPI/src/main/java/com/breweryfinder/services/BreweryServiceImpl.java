package com.breweryfinder.services;

import com.breweryfinder.dao.BreweryDao;
import com.breweryfinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

/**  Interacts with both ExternalAPIClient (to fetch breweries) and the BreweryDao (to perform database operations).*/
@Component
public class BreweryServiceImpl implements BreweryService {

    @Autowired
    BreweryDao breweryDao;
    @Autowired
    OpenBreweryAPI openBreweryAPI;

    /** The methods that get by Name, City, and Zip first check the app's database
     * for breweries that match the search term, then call the public API for any
     * additional breweries that meet that criteria.
     * Finally, all returned breweries are saved to the database to reduce future
     * external API calls, improving the app's efficiency.
     */

    @Override
    public List<Brewery> getBreweriesByName(String breweryName) {
        // Check database for breweryName and add matching breweryObject(s) found to an ArrayList
        List<Brewery> breweryList = breweryDao.getBreweriesByName(breweryName);
        // If brewery not found in the database, fetch from the public API
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByName(breweryName);
        }
        saveBreweries(breweryList); // save brewery list to the database
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        List<Brewery> breweryList = breweryDao.getBreweriesByCity(city);
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByCity(city);
        }
        saveBreweries(breweryList);
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        List<Brewery> breweryList = breweryDao.getBreweriesByZip(zipCode);
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByZip(zipCode);
        }
        saveBreweries(breweryList);
        return breweryList;
    }

    @Override
    public List<Brewery> getFavoritesByUserId(int userId) {
        return breweryDao.getFavoritesByUserId(userId);
    }

    @Override
    public void saveBreweries(List<Brewery> breweryList) {
        // For each brewery in the ArrayList, add it to the database
        for (Brewery brewery : breweryList) {
            addBreweryToDatabase(brewery);
        }
    }

    @Override
    public boolean addBreweryToDatabase(Brewery newBrewery) {
        List<Brewery> existingBreweriesInDb = breweryDao.getBreweries();
        // Check if the brewery already exists in the database
        for (Brewery brewery : existingBreweriesInDb) {
            if (brewery.getBreweryName().equalsIgnoreCase(newBrewery.getBreweryName())) {
                return false; // Brewery already exists, return false to indicate it wasn't added
            }
        }
        // If the brewery doesn't exist, add it to the database
        return breweryDao.addNewBrewery(newBrewery);
    }

}
