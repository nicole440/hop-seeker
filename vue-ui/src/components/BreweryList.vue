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
          <tr v-for="brewery in breweries" :key="brewery.id">
            <td class="brewery-name">{{ brewery.name }}</td>
            <td class="brewery-address">{{ brewery.address }}</td>
            <td class="brewery-city">{{ brewery.city }}</td>
            <td class="brewery-zip">{{ brewery.zip }}</td>
            <td class="brewery-phone">{{ brewery.phone }}</td>
            <td class="brewery-lat-long">{{ brewery.latitude }}, {{ brewery.longitude }}</td>
            <td class="brewery-website">{{ brewery.website }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
  
<script>
import { useStore } from '../stores/authStore'
import BreweryService from '../services/BreweryService'

export default {
  name: 'brewery-list',
  props: {
    breweries: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      breweries: [],
      brewery: {
        id: "",
        name: "",
        address: "",
        city: "",
        zip: "",
        phone: "",
        latitude: "",
        longitude: "",
        website: ""
      }
    }
  },
  // computed: {
  //   userId() {
  //     const authStore = useStore()
  //     return authStore.getUserId
  //   }
  // },
  created() {
    const authStore = useStore()

    BreweryService.getBreweryList().then((response) => {
      this.breweries = response.data;
      console.log(response.data)
    })
      .catch((error) => {
        console.error('Error fetching brewery data:', error);
      });
  },
  // methods: {

  // }
}
</script>