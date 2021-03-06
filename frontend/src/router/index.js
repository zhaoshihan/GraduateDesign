import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index.js'

// @ is an alias to /src
// import Register from '../views/Register'
// import Login from '../views/Login'

// import MemberHome from '../views/MemberHome'

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
    name: 'MemberHome',
    meta: {
      title: '会员主页',
      requireAuth: true
    },
    component: () => import('../views/MemberHome.vue')
    // component: MemberHome
  },
  {
    path: '/ebook',
    name: 'Ebook',
    meta: {
      title: '电子书页',
      requireAuth: true
    },
    component: () => import('../views/Ebook.vue')
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

  console.log('in router before each method: ' + from.path + ' ==>> ' + to.path)
  if (to.meta.requireAuth) {
    if (store.getters.isLoggedIn) {
      next()
      return
    }
    next('/login')
  } else {
    next()
  }

  // if (to.meta.requireAuth) {
  //   console.log('current localstorage token = ' + window.localStorage.token)
  //   if (window.localStorage.token) {
  //     console.log('token exist')
  //     next()
  //   } else {
  //     console.log('token not exist')
  //     next({ path: '/login' })
  //   }

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
})


// router.afterEach((to, from, next) => {
//   window.scrollTo(0, 0)
// })

export default router
