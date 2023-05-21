package com.breweryfinder.dao;

import com.breweryfinder.models.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public List<Brewery> searchBreweriesByName(String breweryName) {
        String sql = "SELECT brewery_id, brewery_name, street_address, city, zip_code, website FROM breweries WHERE brewery_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryName);
        List<Brewery> breweryList = new ArrayList<>();
        while (results.next()) {
            breweryList.add(mapRowToBreweries(results));
        }
        return breweryList;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        String sql = "SELECT brewery_id, brewery_name, street_address, city, zip_code, website FROM breweries WHERE city = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, city);
        List<Brewery> breweryList = new ArrayList<>();
        while (results.next()) {
            breweryList.add(mapRowToBreweries(results));
        }
        return breweryList;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        String sql = "SELECT brewery_id, brewery_name, street_address, city, zip_code, website FROM breweries WHERE zip_code = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, zipCode);
        List<Brewery> breweryList = new ArrayList<>();
        while (results.next()) {
            breweryList.add(mapRowToBreweries(results));
        }
        return breweryList;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public List<Brewery> getFavoritesByUserId(int userId) {
        String sql = "SELECT b.brewery_id, brewery_name, street_address, city, zip_code, website FROM breweries AS b " +
        "JOIN user_favorites AS uf ON uf.brewery_id = b.brewery_id " +
        "WHERE uf.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Brewery> breweryList = new ArrayList<>();
        while (results.next()) {
            breweryList.add(mapRowToBreweries(results));
        }
        return breweryList;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public boolean addNewBrewery(Brewery newBrewery) {
        Brewery brewery = new Brewery();
        String sql = "INSERT INTO breweries (brewery_name, street_address, city, zip_code, website) VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, newBrewery.getBreweryName(), newBrewery.getBreweryStreetAddress(), newBrewery.getBreweryCity(), newBrewery.getBreweryZipCode(), newBrewery.getBreweryWebsite());
        return newBrewery == null ? false : true;
    }

    // TODO "bad SQL grammar"? Look into this
    @Override
    public boolean saveBreweries(List<Brewery> breweryList) {
        List<Brewery> breweries = new ArrayList<>();
        for (Brewery brewery : breweryList) {
            addNewBrewery(brewery);
            if (breweries.size() > 0) {
                return true;
            }
        }
        return false;
    }

    private Brewery mapRowToBreweries(SqlRowSet rowSet) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rowSet.getInt("brewery_id"));
        brewery.setBreweryName(rowSet.getString("brewery_name"));
        brewery.setBreweryStreetAddress(rowSet.getString("street_address"));
        brewery.setBreweryCity(rowSet.getString("city"));
        brewery.setBreweryZipCode(rowSet.getString("zip_code"));
        brewery.setBreweryWebsite(rowSet.getString("website"));
        return brewery;
    }
}
