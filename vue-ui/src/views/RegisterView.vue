<template>
    <main>
        <div id="register" class="main-container">
            <h1>Create Account</h1>
            <form @submit.prevent="register">
                <div class="form-input-group">
                    <label for="username">Username: </label>
                    <input type="text" placeholder="username" id="username" v-model="user.username" required autofocus />
                </div>
                <div class="form-input-group">
                    <label for="dateOfBirth">Date of Birth: </label>
                    <input type="date" id="dateOfBirth" v-model="user.dateOfBirth" required />
                </div>
                <div class="form-input-group">
                    <label for="password">Password: </label>
                    <input type="password" placeholder="password" id="password" v-model="user.password" required />
                </div>
                <div class="form-input-group">
                    <label for="confirmPassword">Confirm Password: </label>
                    <input type="password" placeholder="confirm password" id="confirmPassword"
                        v-model="user.confirmPassword" required />
                </div>
                <button class="submit-button" type="submit">Submit</button>
                <div class="alt-route-prompt">
                    <h3>Already have an account? </h3>
                    <RouterLink to="login">Log in</RouterLink>
                </div>
            </form>
            <div role="alert" v-if="registrationErrors">
                <span class="error">{{ registrationErrorMsg }}</span>
            </div>
            <div role="alert" v-if="this.$route.query.registration">
                Thank you for registering, please sign in.
            </div>
        </div>
    </main>
</template>
  
<script>
import authService from '../services/AuthService'
import { RouterLink } from 'vue-router'

export default {
    name: "register",
    components: { RouterLink },
    data() {
        return {
            user: {
                username: "",
                password: "",
                confirmPassword: "",
                dateOfBirth: "",
                role: "user"
            },
            registrationErrors: false,
            registrationErrorMsg: "There were problems registering this user."
        };
    },
    methods: {
        formatDate(dateOfBirth) {
            let dob = new Date(dateOfBirth);
            let month = "" + (dob.getMonth() + 1); // Add 1 to get the correct month (0-11)
            let day = "" + (dob.getDate() + 1); // Add 1 to get the correct date (0-30)
            let year = "" + dob.getFullYear();
            let formattedDate = [year, month.padStart(2, "0"), day.padStart(2, "0")].join("-");
            return formattedDate;
        },

        async register() {
            this.user.dateOfBirth = this.formatDate(this.user.dateOfBirth);

            if (this.user.password !== this.user.confirmPassword) {
                this.registrationErrors = true;
                this.registrationErrorMsg = "Password & Confirm Password do not match.";
                return;
            }
            // Add validation to ensure that user is 21+
            try {
                console.log(this.user);
                const response = await authService.register(this.user);
                if (response.status === 201) {
                    this.$router.push({
                        path: "/login",
                        query: { registration: "success" }
                    });
                }
            }
            catch (error) {
                const response = error.response;
                this.registrationErrors = true;
                if (response && response.status === 400) {
                    this.registrationErrorMsg = "Bad Request: Validation Errors";
                }
            }
        },
        clearErrors() {
            this.registrationErrors = false;
            this.registrationErrorMsg = "There were problems registering this user.";
        }
    }
}
</script>