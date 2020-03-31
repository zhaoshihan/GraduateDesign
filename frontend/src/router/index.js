import Vue from 'vue'
import VueRouter from 'vue-router'

// @ is an alias to /src
import Login from '../views/Login'
import Home from '../views/Home'

import store from '../store/user'
import Axios from 'axios'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'Login',
    meta: {
      title: '登陆页',
      requireAuth: false
    },
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    meta: {
      title: '主页',
      requireAuth: true
    },
    component: Home
  }
  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = new VueRouter({
  routes
})

// router.beforeEach(function (transition) {
//   console.log(transition.to)
//   const vm = transition.to.app.$root
//   if (transition.to.meta.requireAuth) {
//     vm.$axios.create({
//       method: 'post',
//       url: '/token/check',
//       auth: vm.$store.state.tokens
//     }).then(response => {
//       console.log(response)
//       transition.next()
//     }).catch(error => {
//       console.log(error)
//       transition.next('/login')
//     })
//   } else {
//     transition.next()
//   }
// })
//
router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title
  if (to.meta.requireAuth) {
    // console.log(store.state)
    // console.log('current token is' + store.state.token)
    const axiosInstance = Axios.create({
      baseURL: 'http://localhost:8081',
      headers: {
        auth_token: store.state.token
      }
    })
    axiosInstance.post('/token/check', null
    ).then(response => {
      console.log(response)
      next()
    }).catch(error => {
      console.warn(error)
      next({ path: '/login' })
    })
  } else {
    next()
  }
})

// router.afterEach((to, from, next) => {
//   window.scrollTo(0, 0)
// })

export default router
