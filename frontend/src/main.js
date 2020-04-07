import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import BootrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.min.css'
import '@/assets/styles/icon.css'
import '@/assets/styles/global.scss'
import '@fortawesome/fontawesome-free/css/all.min.css'

import Axios from 'axios'
import md5 from 'js-md5'

// 为Axios进行统一的config设置
Axios.defaults.baseURL = 'http://localhost:8081'

// 为Axios添加请求拦截器和响应拦截器，统一进行错误处理（免去逐个使用catch）
Axios.interceptors.request.use(
  config => {
    if (window.localStorage.token) {
      // 如果token值不为空，则自动添加入request headers中
      config.headers.Authorization = window.localStorage.token
    }
    return config
  }, error => {
    // 统一处理请求错误，以4xx状态码开头，表示客户端错误
    console.warn(error)
    return Promise.reject(error)
  }
)
Axios.interceptors.response.use(
  config => {
    return config
  }, error => {
    // 响应错误，以5xx状态码开头，表示服务端错误
    console.warn(error)
    return Promise.reject(error)
  }
)

Vue.use(BootrapVue)

// 将Axios与Vue实例绑定
Vue.prototype.$axios = Axios
// 一般我们把登录和注册信息的密码进行加密
Vue.prototype.$md5 = md5
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
