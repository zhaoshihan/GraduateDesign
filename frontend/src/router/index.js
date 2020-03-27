import Vue from 'vue'
import VueRouter from 'vue-router'

// @ is an alias to /src
import Login from '../views/Login'
import Home from '../views/Home'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    meta: {
      title: '登陆'
    },
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    meta: {
      title: '主页'
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

router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title
  next()
})

router.afterEach((to, from, next) => {
  window.scrollTo(0, 0)
})

export default router
