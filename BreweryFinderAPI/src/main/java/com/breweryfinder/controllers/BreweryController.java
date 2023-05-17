package com.breweryfinder.controllers;

import com.breweryfinder.dao.BreweryDao;
import com.breweryfinder.models.Brewery;
import com.breweryfinder.services.BreweryServiceImpl;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Receives HTTP requests from the frontend and delegates the processing to BreweryService */
@RestController
@RequestMapping("/api/external/breweries")
@CrossOrigin // Allow calls within domain but not from same port
public class BreweryController {

    private BreweryServiceImpl breweryService;
    private BreweryDao breweryDao;

    public BreweryController(BreweryServiceImpl breweryService, BreweryDao breweryDao) {
        this.breweryService = breweryService;
        this.breweryDao = breweryDao;
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Brewery>> getAllBreweries() {
//        List<Brewery> breweryList = breweryService.getAllBreweries();
//        return new ResponseEntity<>(breweryList, HttpStatus.OK);
//    }

    @GetMapping("/name/{breweryName}")
    public ResponseEntity<List<Brewery>> getBreweriesByName(@PathVariable String breweryName) {
        List<Brewery> breweryList = breweryService.getBreweriesByName(breweryName);
        return new ResponseEntity<>(breweryList, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Brewery>> getBreweriesByCity(@PathVariable String city) {
            List<Brewery> breweryList = breweryService.getBreweriesByCity(city);
            return new ResponseEntity<>(breweryList, HttpStatus.OK);
    }

    @GetMapping("/zip/{zipCode}")
    public ResponseEntity<List<Brewery>> getBreweriesByZip(@PathVariable String zipCode) {
        List<Brewery> breweryList = breweryService.getBreweriesByZip(zipCode);
        return new ResponseEntity<>(breweryList, HttpStatus.OK);
    }

    @GetMapping("/favorites/{userId}")
    public ResponseEntity<List<Brewery>> getFavoritesByUserId(@PathVariable int userId, @RequestBody List <Brewery> favoritesList) {
        List<Brewery> favorites = breweryDao.getFavoritesByUserId(userId);
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/new")
    public boolean addBrewery(@RequestBody Brewery newBrewery) {
        return breweryDao.addNewBrewery(newBrewery);
    }

}
