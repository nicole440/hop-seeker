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
        this.brewery = response.data;
        console.log(response.data)
      });
    },
    methods: {

    }
  }
  </script>
  
  <!-- <style>
  .profile-img {
    max-height: 30px;
    max-width: 30px;
    border-radius: 50%;
    border: 2px white solid;
  }
  
  .large-profile-img {
    max-height: 75px;
    max-width: 75px;
    border-radius: 50%;
    border: 2px white solid;
  }
  
  .modal {
    display: none;
  }
  
  .modal.is-active {
    display: flex !important;
    align-items: center;
    justify-content: center;
  }
  
  .modal-background {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0, 0, 0, 0.5);
  }
  
  .modal-content {
    background-color: #fff;
    border-radius: 4px;
    padding: 1rem;
  }
  
  .modal-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid #ccc;
    padding-bottom: 0.5rem;
    margin-bottom: 0.5rem;
  }
  
  .modal-title {
    margin: 0;
  }
  
  .modal-body {
    margin-bottom: 1rem;
  }
  
  .modal-footer {
    display: flex;
    justify-content: flex-end;
  }
  </style> -->