<script setup>
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

h1 {
    grid-area: head;
    text-align: center;
}

.form-input-group {
    grid-area: input;
    max-width: auto;
    padding: 15px;
}

.submit-button {
    width: fit-content;
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