import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import LogoutView from '../views/LogoutView.vue'
import FavoritesView from '../views/FavoritesView.vue'
import SearchView from '../views/SearchView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: LogoutView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/favorites",
      name: "favorites",
      component: FavoritesView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/search",
      name: "search",
      component: SearchView,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

export default router
