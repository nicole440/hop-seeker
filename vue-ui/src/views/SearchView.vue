<template>
    <main>
        <div class="main-container">
            <h1>Search Breweries</h1>
            <h3>Search by any one of the following criteria:</h3>
            <form @submit.prevent="search">
                <div class="form-input-group">
                    <label for="breweryName">Brewery Name: </label>
                    <input type="text" placeholder="name" class="breweryName">
                </div>
                <div class="form-input-group">
                    <label for="breweryCity">City: </label>
                    <input type="text" placeholder="city" class="breweryCity">
                </div>
                <div class="form-input-group">
                    <label for="breweryZip">Zip Code: </label>
                    <input type="text" placeholder="zip Code" class="breweryZip">
                </div>
                <button class="submit-button" type="submit">Search</button>
            </form>
        </div>
    </main>
</template>

<script>
import BreweryList from "../components/BreweryList.vue";

export default {
    name: "search",
    components: {
        BreweryList
    },
    data() {
        return {
            breweries: []
        }
    }
}
</script>

