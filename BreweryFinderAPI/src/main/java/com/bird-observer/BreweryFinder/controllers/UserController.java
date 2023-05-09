package com.example.BreweryFinder.controllers;

import com.example.BreweryFinder.dao.BreweryDao;
import com.example.BreweryFinder.dao.UserDao;
import com.example.BreweryFinder.models.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // Allow calls within domain but not from same port
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BreweryDao breweryDao;

    public UserController(UserDao userDao, BreweryDao breweryDao) {
        this.userDao = userDao;
        this.breweryDao = breweryDao;
    }

    @RequestMapping(path="/breweries/favorites/{userId}", method = RequestMethod.GET)
    public List<Brewery> getCurrentUserFavorites(@PathVariable int userId) {
        List<Brewery> favoritesList = breweryDao.getFavoritesByUserId(userId);
        return favoritesList;
    }
}
