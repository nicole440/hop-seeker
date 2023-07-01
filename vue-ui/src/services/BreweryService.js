import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    getBreweriesByName(name) {
        return http.get(`/api/external/breweries/name/${name}`)
    },
    getBreweriesByCity(city) {
        return http.get(`/api/external/breweries/city/${city}`)
    },
    getBreweriesByZip(zip) {
        return http.get(`/api/external/breweries/zip/${zip}`)
    }
}