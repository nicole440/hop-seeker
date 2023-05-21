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

    // TODO finish refactoring so duplicative breweries stop being saved to database and revise subsequent methods re: same
    @Override
    public List<Brewery> getBreweriesByName(String breweryName) {
        // Check database for breweries and add matching items found to an ArrayList
        List<Brewery> breweryList = breweryDao.getBreweriesByName(breweryName);
        // If data not found in the database, fetch from the public API
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByName(breweryName);
            saveBreweries(breweryList); // add the brewery to the database

        } else { // if the brewery database does contain the breweries matching the search
            breweryList.add((Brewery) openBreweryAPI.getBreweriesByName(breweryName)); // add each API-returned brewery to the list
            saveBreweries(breweryList); // save all to database
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        List<Brewery> breweryList = breweryDao.getBreweriesByCity(city);
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByCity(city);

            saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        List<Brewery> breweryList = breweryDao.getBreweriesByZip(zipCode);
        if (breweryList.isEmpty()) {
            breweryList = openBreweryAPI.getBreweriesByZip(zipCode);

            saveBreweries(breweryList);
        }
        return breweryList;
    }

    @Override
    public List<Brewery> getFavoritesByUserId(int userId) {
        return breweryDao.getFavoritesByUserId(userId);
    }

    @Override
    public void saveBreweries(List<Brewery> breweryList) {
        for (Brewery brewery : breweryList) {
           addBrewery(brewery);
        }
    }

    @Override
    public boolean addBrewery(Brewery newBrewery) {
        if (!breweryDao.getBreweries().contains(newBrewery)) {
            return breweryDao.addNewBrewery(newBrewery);
        }
        return false;
    }
}
