package com.example.BreweryFinder.controllers;

import com.example.BreweryFinder.dao.BreweryDao;
import com.example.BreweryFinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin // Allow calls within domain but not from same port
public class BreweryController {

    @Autowired
    private BreweryDao breweryDao;

    @RequestMapping(path="/breweries/{breweryName}", method = RequestMethod.GET)
    public List<Brewery> searchBreweriesByName(@PathVariable String breweryName) {
        return breweryDao.searchBreweriesByName(breweryName);
    }

    @RequestMapping(path="/breweries/{city}", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByCity(@PathVariable String city) {
        return breweryDao.getBreweriesByCity(city);
    }

    @RequestMapping(path="/breweries/{zipCode}", method = RequestMethod.GET)
    public List<Brewery> getBreweriesByZip(@PathVariable String zipCode) {
        return breweryDao.getBreweriesByZip(zipCode);
    }

}
