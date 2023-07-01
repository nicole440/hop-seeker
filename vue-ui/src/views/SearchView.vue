<template>
    <div class="form-container">
    <h1>Search Breweries</h1>
    <h2>Search by any one of the following criteria</h2>
    <form @submit.prevent="search">
      <div class="form-input-group">
        <label for="breweryName">Brewery Name: </label>
        <input type="text" placeholder="Name" class="breweryName">
        <label for="breweryCity">City: </label>
        <input type="text" placeholder="City" class="breweryCity">
        <label for="breweryZip">Zip Code: </label>
        <input type="text" placeholder="Zip Code" class="breweryZip">
      </div>
      <button class="submit-button" type="submit">Search</button>
      </form>
      </div>
</template>

<script>
import { RouterLink } from "vue-router";

export default {
    name: "search",
    data() {
        return {
            
        }
    }
}
</script>

