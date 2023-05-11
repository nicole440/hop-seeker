package service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class BreweryService {


    @GetMapping("/breweries/all")
    public ResponseEntity<String> getAllBreweries() {
        String apiUrl = "https://api.openbrewerydb.org/v1/breweries";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer <your-access-token>");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return response;
    }
}
