<template>
  <main>
    <div class="main-container">
      <h1>Please sign in</h1>
      <form @submit.prevent="login">
        <div class="form-input-group">
          <label for="loginUsername">Username: </label>
          <input type="text" placeholder="username" v-model="user.username" required>
        </div>
        <div class="form-input-group">
          <label for="loginPassword">Password: </label>
          <input type="password" placeholder="password" v-model="user.password" required>
        </div>
        <button class="submit-button" type="submit">Login</button>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div class="alt-route-prompt">
          <h3>Need an account? </h3>
          <RouterLink to="register">Sign up</RouterLink>
        </div>
      </form>
    </div>
  </main>
</template>

<script>
import authService from "../services/AuthService"
import { useStore } from '../stores/authStore'
import { RouterLink } from "vue-router"

export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {

      const authStore = useStore();

      authService
        .login(this.user)
        .then((response) => {
          console.log(response.status)
          if (response.status == 200) {
            authStore.SET_AUTH_TOKEN(response.data.token);
            authStore.SET_USER(response.data.user);
            this.$router.push("/authorized");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
  components: { RouterLink }
};
</script>