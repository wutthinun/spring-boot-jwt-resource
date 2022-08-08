import { createApp } from 'vue'
import './style.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import App from './App.vue'
import Home from './components/Home.vue'
import Login from './components/Login.vue'

import {createRouter, createWebHashHistory} from 'vue-router';

const routes = [
  {path: "/", component: Home},
  {path: "/login", component: Login}
]

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

createApp(App)
  .use(router)
  .mount('#app')
