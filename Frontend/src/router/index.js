import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ContactForms from "../views/ContactForms.vue";
import LoginPage from "../views/LoginPage.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/contactforms",
    name: "ContactForms",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: ContactForms
  },
  {
    path: "/loginpage",
    name: "LoginPage",
    component: LoginPage
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;