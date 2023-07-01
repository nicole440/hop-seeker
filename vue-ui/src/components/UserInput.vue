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
h1 {
    grid-area: head;
    text-align: center;
}

.form-input-group {
    grid-area: input;
    max-width: auto;
    padding: 15px;
    margin: 15px;
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

@media (max-width: 1024px) {
    .form-container {
        min-height: 100vh;
        display: flex;
        align-items: center;
        text-align: center;
        padding: 5px;
    }
    h3 {
        font-size: 1em;
    }
}
</style>