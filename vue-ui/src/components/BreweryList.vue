<template>
  <div>
    <div>
      <table class="brewery-table">
        <thead>

            <th>Name</th>
            <th>Address</th>
            <th>City</th>

        </thead>
        <tbody>
          <tr v-for="brewery in breweries" :key="brewery.id" :brewery="brewery">
            <td class="brewery-name">{{ brewery.name }}</td>
            <td class="brewery-address">{{ brewery.address }}</td>
            <td class="brewery-city">{{ brewery.city }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
  
<script>

export default {
  name: 'brewery-list',
  props: {
    breweries: {
      type: Array,
      default: () => []
    },
  },
  // 
  // data() {
  //   return {
  //     breweries: [],
  //     brewery: {
  //       name: "",
  //       city: "",
  //       zip: ""
  //     }
  //   }
  // },
  created() {
    console.log("BreweryList - created:", this.breweries);  
    // why can't I delete this commented-out code without the application breaking???
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