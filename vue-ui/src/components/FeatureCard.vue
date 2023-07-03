<script setup>
import FeatureItem from './FeatureItem.vue'
</script>

<template>
  <div class="info-container">
    <SummaryCard />
    <FeatureItem>
      <template #icon>
        <span class="material-symbols-outlined">search</span>
      </template>
      <template #heading>Search</template>
      Search for Pennsylvania breweries by name, city, or zip code.
    </FeatureItem>

    <FeatureItem>
      <template #icon>
        <span class="material-symbols-outlined">favorite</span>
        <!-- use heart_plus on actual button to favorite a brewery, and show heart_check when user has brewery already on their list -->
      </template>
      <template #heading>Favorites</template>
      Create an account to keep track of your favorite breweries, tag their best features, and leave a note about what you
      loved!
    </FeatureItem>

    <FeatureItem>
      <template #icon>
        <span class="material-symbols-outlined">diversity_3</span>
      </template>
      <template #heading>Community</template>
      Beer-drinking is a social activity! On each brewery's page, you can see how many users loved that brewery.
    </FeatureItem>

    <FeatureItem>
      <template #icon>
        <span class="material-symbols-outlined">location_on</span>
      </template>
      <template #heading>Beer Near Here</template>
      Search by your current location.
    </FeatureItem>
  </div>
</template>

<style>
.material-symbols-outlined {
  font-variation-settings:
    'FILL' 1,
    'wght' 400,
    'GRAD' -25,
    'opsz' 48
}
</style>