<template>
  <div class="form-container">
    <h1>Please sign in</h1>
    <form @submit.prevent="login">
      <div class="form-input-group">
        <label for="loginUsername">Username: </label>
        <input type="text" placeholder="Username" class="loginUsername" v-model="user.username" required>
        <label for="loginPassword">Password: </label>
        <input type="password" placeholder="Password" class="loginPassword" v-model="user.password" required>
      </div>
      <button class="submit-button" type="submit">Login</button>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="alt-route-prompt">
        <h3>Need an account? </h3>
        <RouterLink to="register" class="signup">Sign up</RouterLink>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import { useStore } from '../stores/authStore';
import { RouterLink } from "vue-router";

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

<!-- <style scoped>
body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
}

.form-container {
  margin: 0 auto;
  padding: 20px;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: "head"
                        "input"
                        "button"
                        "reg";
  width: 300px;
  justify-content: center;
}

h1 {
  grid-area: head;
  text-align: center;
}

.input {
  grid-area: input;
  max-width: 300px;
  padding: 15px;
}

.register-prompt {
  grid-area: reg;
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

  .submit-button {
    grid-area: button;
  }
} 
</style>-->

