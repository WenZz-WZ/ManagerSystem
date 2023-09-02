import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login.vue";
import Home from "../views/Home.vue";
import Test from "../views/Test.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    children: [
      {
        path: '/test',
        name: 'Test',
        component: Test
      }
    ]
  },

]

const router = new VueRouter({
  routes
})

export default router
