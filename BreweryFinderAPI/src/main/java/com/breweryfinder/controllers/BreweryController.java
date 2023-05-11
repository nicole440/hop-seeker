package com.breweryfinder.controllers;

import com.breweryfinder.dao.BreweryDao;
import com.breweryfinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("https://api.openbrewerydb.org/v1/breweries")
@CrossOrigin // Allow calls within domain but not from same port
public class BreweryController {

    @Autowired
    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<Brewery> getAllBreweries() {
        return breweryDao.getAllBreweries();
    }

    @RequestMapping(path="?by_name={breweryName}&per_page=3", method = RequestMethod.GET)
    public List<Brewery> searchBreweriesByName(@PathVariable String breweryName) {
        return breweryDao.searchBreweriesByName(breweryName);
    }

    @RequestMapping(path="?by_city={city}&per_page=3", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByCity(@PathVariable String city) {
        return breweryDao.getBreweriesByCity(city);
    }

    @RequestMapping(path="?by_postal={zipCode}&per_page=3", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByZip(@PathVariable String zipCode) {
        return breweryDao.getBreweriesByZip(zipCode);
    }

}
