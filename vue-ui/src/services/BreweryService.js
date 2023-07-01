import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/api/external"
});

export default {
    getBreweriesByName(name) {
        return http.get(`/breweries/name/${name}`)
    },
    getBreweriesByCity(city) {
        return http.get(`/breweries/city/${city}`)
    },
    getBreweriesByZip(zip) {
        return http.get(`/breweries/zip/${zip}`)
    },
    getFavoritesByUser(user) {
        return http.get(`/favorites/${user}`)
    }
}