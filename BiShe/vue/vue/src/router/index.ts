import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: () => import('../views/LoginView.vue'),
      
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('../views/HomeView.vue'),
    }
    // {
    //   path: '/login',
    //   name: 'login',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/LoginView.vue'),
    //   children:[
    //     {
    //       path:'/login/login',
    //       name:'login',
    //       component:() => import('../components/Login.vue'),
    //     },
    //     {
    //       path: '/login/register',
    //       name: 'register',
    //       component: () => import('../components/Register.vue'),
    //     },
    //   ]
    // },
    
  ]
})

export default router
