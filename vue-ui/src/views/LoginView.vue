<template>
  <div class="login">
    <h1>This is a login page</h1>

    <main class="form-signin w-100 m-auto">
      <form @submit.prevent="login">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="Username" v-model="user.username"
            required>
          <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="user.password"
            required>
          <label for="floatingPassword">Password</label>
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <router-link :to="{ name: 'register' }" class="signup">Sign up</router-link>
      </form>
    </main>

  </div>
</template>

<script>
import authService from "../services/AuthService";
import { useStore } from '../stores/authStore';

export default {
  name: "login",
  components: {},
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

.form-signin {
  max-width: 330px;
  padding: 15px;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.btn-primary {
  background-color: #b9700f;
  border: #b9700f 2px solid;
}

.btn-primary:hover {
  border: #FFF 2px solid;
  background-color: #e0d0bc;
  color: #b9700f;
}

.signup {
  font-size: 18px;
  color: #b9700f;
  font-style: italic;
}
.signup:hover {
  border: none;
  color:#FFF;
}
</style>