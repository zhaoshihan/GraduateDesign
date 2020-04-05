import Vue from 'vue'
import VueRouter from 'vue-router'

// @ is an alias to /src
// import Register from '../views/Register'
// import Login from '../views/Login'
import Home from '../views/Home'

// import store from '../store/user'
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
    component: () => import('../views/Login.vue')
  },
  {
    path: '/register',
    name: 'Register',
    meta: {
      title: '注册页',
      requireAuth: false
    },
    component: () => import('../views/Register.vue')
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

router.beforeEach((to, from, next) => {
  window.document.title = to.meta.title
  if (to.meta.requireAuth) {
    console.log('current localstorage token = ' + window.localStorage.token)
    if (window.localStorage.token) {
      console.log('token exist')
      next()
    } else {
      console.log('token not exist')
      next({ path: '/login' })
    }
    // const axiosInstance = Axios.create({
    //   baseURL: 'http://localhost:8081',
    //   headers: {
    //     Auth_Token: store.state.token
    //   }
    // })
    // // 这个后端接口是空的
    // axiosInstance.post('/token/check', null
    // ).then(response => {
    //   console.log(response)
    //   next()
    // }).catch(error => {
    //   console.warn(error)
    //   next({ path: '/login' })
    // })
  } else {
    next()
  }
})

// router.afterEach((to, from, next) => {
//   window.scrollTo(0, 0)
// })

export default router
