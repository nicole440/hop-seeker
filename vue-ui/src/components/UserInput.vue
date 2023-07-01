<script setup>
import authService from '../services/AuthService'
import { RouterLink } from 'vue-router'
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import SearchView from '../views/SearchView.vue';
</script>

<template>
    <LoginView />
    <RegisterView />
    <SearchView />
</template>

<style>
.form-container {
    margin: 0 auto;
    padding: 20px;
    display: grid;
    grid-template-columns: 1fr;
    grid-template-areas: "head"
        "input"
        "button"
        "reroute";
    width: 300px;
    justify-content: center;
}

h1 {
    grid-area: head;
    text-align: center;
}

.form-input-group {
    grid-area: input;
    max-width: 300px;
    padding: 15px;
}

.submit-button {
    grid-area: button;
    padding: 2px;
}

.alt-route-prompt {
    grid-area: reroute;
    padding-top: 10px;
    text-align: center;
}

@media (min-width: 1024px) {
    .form-container {
        /* min-height: 100vh; */
        display: flex;
        align-items: center;
        text-align: center;
        padding: 5px;
    }
}
</style>