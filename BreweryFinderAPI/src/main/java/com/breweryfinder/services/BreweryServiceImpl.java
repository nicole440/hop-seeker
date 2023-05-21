package com.breweryfinder.services;

import com.breweryfinder.dao.BreweryDao;
import com.breweryfinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
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
        // Check database for breweries and add matching items found to an ArrayList
        List<Brewery> breweryList = breweryDao.searchBreweriesByName(breweryName);
        // If data not found in the database, fetch from the public API
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByName(breweryName);
            // Store the fetched data in the database for future use
            breweryDao.saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        List<Brewery> breweryList = breweryDao.getBreweriesByCity(city);
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByCity(city);
            breweryDao.saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        List<Brewery> breweryList = breweryDao.getBreweriesByZip(zipCode);
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByZip(zipCode);
            breweryDao.saveBreweries(breweryList);
        }
        return breweryList;
    }

    /** The below methods just call the database directly because
     * HopSeeker user favorites are not a component of the public API
     */
    @Override
    public List<Brewery> getFavoritesByUserId(int userId) {
        return breweryDao.getFavoritesByUserId(userId);
    }

    @Override
    public boolean addBrewery(Brewery newBrewery) {
        return breweryDao.addNewBrewery(newBrewery);
    }
}
