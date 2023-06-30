<template>
  <div class="login">
    <h1>Please sign in</h1>
    <form @submit.prevent="login">
      <div class="input">
        <label for="loginUsername">Username: </label>
        <input type="text" placeholder="Username" class="loginUsername" v-model="user.username" required>
        <label for="loginPassword">Password: </label>
        <input type="password" placeholder="Password" class="loginPassword" v-model="user.password" required>
      </div>
      <button class="loginButton" type="submit">Login</button>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="register-prompt">
        <h3>Need an account? </h3>
        <RouterLink to="register" class="signup">Sign up</RouterLink>
      </div>
    </form>

    <!-- <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div> -->


    <!-- <router-link :to="{ name: 'register' }" class="signup">Sign up</router-link>
      </form>
      </div> -->
  </div>
</template>

<script>
import authService from "../services/AuthService";
import { useStore } from '../stores/authStore';

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
};
</script>

<!-- <style>
@media (min-width: 1024px) {
  .login {
    min-height: 100vh;
    display: flex;
    align-items: center;
    padding: 5px;
  }
}
</style> -->

<style scoped>
body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
}

.login {
  margin: 0 auto;
  padding: 20px;
}

.input {
  display: grid;
  max-width: 200px;
  padding-bottom: 15px;
}

.register-prompt {
  padding-top: 10px;
}
</style>