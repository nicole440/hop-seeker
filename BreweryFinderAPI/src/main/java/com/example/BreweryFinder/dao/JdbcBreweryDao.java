package com.example.BreweryFinder.dao;

import com.example.BreweryFinder.models.Brewery;
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

    @Override
    public List<Brewery> searchBreweriesByName(String breweryName) {
        List<Brewery> results = new ArrayList<>();
        String sql = "SELECT brewery_name, street_address, city, zip_code, website FROM breweries WHERE brewery_name = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            Brewery brewery = mapRowToBreweries(sqlRowSet);
            results.add(brewery);
        }
        return results;
    }

    @Override
    public List<Brewery> getBreweriesByCity(String city) {
        List<Brewery> results = new ArrayList<>();
        String sql = "SELECT brewery_name, street_address, city, zip_code, website FROM breweries WHERE city = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            Brewery brewery = mapRowToBreweries(sqlRowSet);
            results.add(brewery);
        }
        return results;
    }

    @Override
    public List<Brewery> getBreweriesByZip(String zipCode) {
        List<Brewery> results = new ArrayList<>();
        String sql = "SELECT brewery_name, street_address, city, zip_code, website FROM breweries WHERE zip_code = ?;";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        while (sqlRowSet.next()) {
            Brewery brewery = mapRowToBreweries(sqlRowSet);
            results.add(brewery);
        }
        return results;
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
