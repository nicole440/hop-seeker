<template>
  <div>
    <div>
      <table class="brewery-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Zip Code</th>
            <th>Phone Number</th>
            <th>Lat/Long</th>
            <th>Website</th>
          </tr>
        </thead>
        <tbody>
          <BreweryCard v-for="brewery in breweries" :key="brewery.id" :brewery="brewery" />
        </tbody>
      </table>
    </div>
  </div>
</template>
  
<script>
import { useStore } from '../stores/authStore'
import BreweryCard from './BreweryCard.vue';

export default {
  name: 'brewery-list',
  props: {
    breweries: {
      type: Array,
      required: true,
      default: () => []
    }
  },
  components: {
    BreweryCard
  },
  // data() {
  //   return {
  //     breweries: [],
  //     brewery: {
  //       id: "",
  //       name: "",
  //       address: "",
  //       city: "",
  //       zip: "",
  //       phone: "",
  //       latitude: "",
  //       longitude: "",
  //       website: ""
  //     }
  //   }
  // },
  created() {
    const authStore = useStore()
    console.log(this.breweries);
    // BreweryService.getBreweriesByName().then((response) => {
    //   this.breweries = response.data;
    //   console.log(response.data)
    // })
    //   .catch((error) => {
    //     console.error('Error fetching brewery data:', error);
    //   });
  }
}
</script>