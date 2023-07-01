<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HeaderComponent from './components/HeaderComponent.vue'
import { useStore } from './stores/authStore'

const authStore = useStore();
</script>

<template>
  <header>
    <img alt="HopSeeker logo" class="logo" src="@/assets/hop.png" width="125" height="125" />

    <div class="wrapper">
      <HeaderComponent msg="HopSeeker" />

      <nav>
        <div>
          <RouterLink :to="{ name: 'home' }">Home</RouterLink>
          <RouterLink :to="{ name: 'search' }">Search</RouterLink>
          <RouterLink :to="{ name: 'favorites' }" v-if="authStore.tokenCheck != ''">Favorites</RouterLink>
          <RouterLink :to="{ name: 'login' }" v-if="authStore.tokenCheck == ''">Login</RouterLink>
          <RouterLink :to="{ name: 'logout' }" v-if="authStore.tokenCheck != ''" @click="authStore.logout">Logout</RouterLink>
          <RouterLink :to="{ name: 'register' }" v-if="authStore.tokenCheck == ''">Register</RouterLink>
        </div>
      </nav>
    </div>
  </header>
  <RouterView />
</template>

<style>
header {
  line-height: 1.5;
  max-height: 90vh;
  padding: 0 20px;
  background-image: url("https://images.unsplash.com/photo-1600788886242-5c96aabe3757?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen',
    'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue',
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

header .wrapper {
  color: #141414;
  font-size: 30px;
  background-color: #b96b04c4;
  padding: 15px;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (prefers-reduced-motion: no-preference) {
  .logo {
    padding: 5px;
    animation: logo-spin infinite 20s linear;
  }
}

@keyframes logo-spin {
  from {
    transform: rotate(0deg);
  }

  to {
    transform: rotate(360deg);
  }
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
    min-height: 90vh;
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}

@media (max-width: 1024px) {
  header {
    min-width: 90vw;
  }
}

.main-container {
    background-color: rgba(20, 20, 20, 0.6);
    margin: 20px auto;
    padding: 50px;
    display: grid;
    grid-template-columns: 1fr;
    grid-template-areas: "head"
        "input"
        "button"
        "reroute";
    width: 80%;
    justify-content: center;
}

@media (max-width: 1024px) {
  .main-container {
    margin: 0 auto;
    padding: 0;
  }
  h1 {
    font-size: 2em;
  }
}

main {
  position: relative;
}
main::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-image: url("https://images.unsplash.com/photo-1604040605063-8323c2b450cf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  filter: blur(2.5px);
  z-index: -1;
}




</style>
