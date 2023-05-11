package com.breweryfinder.controllers;

import com.breweryfinder.dao.BreweryDao;
import com.breweryfinder.models.Brewery;
import com.breweryfinder.services.BreweryService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // Allow calls within domain but not from same port
public class BreweryController {

    private BreweryService breweryService;
    private BreweryDao breweryDao;

    public BreweryController(BreweryService breweryService, BreweryDao breweryDao) {
        this.breweryService = breweryService;
        this.breweryDao = breweryDao;
    }

    @GetMapping("/breweries/all")
    public ResponseEntity<List<Brewery>> getAllBreweries() {
        List<Brewery> breweries = breweryService.getAllBreweries();
        return new ResponseEntity<>(breweries, HttpStatus.OK);
    }

    @GetMapping("/breweries/{breweryName}")
    public ResponseEntity<List<Brewery>> getBreweriesByName(@PathVariable String breweryName) {
        List<Brewery> breweries = List.of((Brewery) breweryService.getBreweriesByName(breweryName));
        return new ResponseEntity<>(breweries, HttpStatus.OK);
    }

    @GetMapping("/breweries/{city}")
    public ResponseEntity<List<Brewery>> getBreweriesByCity(@PathVariable String city) {
            List<Brewery> breweries = List.of((Brewery) breweryService.getBreweriesByCity(city));
            return new ResponseEntity<>(breweries, HttpStatus.OK);
    }

    @GetMapping("/breweries/{zipCode}")
    public ResponseEntity<List<Brewery>> getBreweriesByZip(@PathVariable String zipCode) {
        List<Brewery> breweries = List.of((Brewery) breweryService.getBreweriesByZip(zipCode));
        return new ResponseEntity<>(breweries, HttpStatus.OK);
    }

    @GetMapping("/breweries/search/{searchTerm}")
    public ResponseEntity<List<Brewery>> searchBreweries(@PathVariable String searchTerm) {
        List<Brewery> breweries = List.of((Brewery) breweryService.searchBreweries(searchTerm));
        return new ResponseEntity<>(breweries, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/breweries/new")
    public boolean addBrewery(@RequestBody Brewery newBrewery) {
        return breweryDao.addNewBrewery(newBrewery);
    }

}
