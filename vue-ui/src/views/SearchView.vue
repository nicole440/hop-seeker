<template>
    <main>
        <div class="main-container">
            <h1>Search Breweries</h1>
            <h3>Search by any one of the following criteria:</h3>
            <div>
                <form @submit.prevent="search">
                    <div class="form-input-group">
                        <label for="breweryName">Brewery Name: </label>
                        <input type="text" placeholder="name" class="breweryName" v-model="brewery.name">
                    </div>
                    <div class="form-input-group">
                        <label for="breweryCity">City: </label>
                        <input type="text" placeholder="city" class="breweryCity" v-model="brewery.city">
                    </div>
                    <div class="form-input-group">
                        <label for="breweryZip">Zip Code: </label>
                        <input type="text" placeholder="zip Code" class="breweryZip" v-model="brewery.zip">
                    </div>
                    <button class="submit-button" type="submit">Search</button>
                </form>
            </div>
        </div>
        <div class="results-container">
            <BreweryList :breweries="breweries" />
        </div>
    </main>
</template>

<script>
import BreweryService from "../services/BreweryService";
import BreweryList from "../components/BreweryList.vue";

export default {
    name: "search",
    components: {
        BreweryList,
    },
    data() {
        return {
            brewery: {
                name: "",
                city: "",
                zip: ""
            }
        }
    },
    methods: {
        search() {
      if (this.brewery.name !== "") {
        BreweryService.getBreweriesByName(this.brewery.name)
          .then((response) => {
            this.breweries = response.data;
          })
          .catch((error) => {
            console.error("Error fetching brewery data:", error);
          });
      } else if (this.brewery.city !== "") {
        BreweryService.getBreweriesByCity(this.brewery.city)
          .then((response) => {
            this.breweries = response.data;
          })
          .catch((error) => {
            console.error("Error fetching brewery data:", error);
          });
      } else if (this.brewery.zip !== "") {
        BreweryService.getBreweriesByZip(this.brewery.zip)
          .then((response) => {
            this.breweries = response.data;
          })
          .catch((error) => {
            console.error("Error fetching brewery data:", error);
          });
      }
    },
  },
};
</script>