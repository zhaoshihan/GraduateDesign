import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import BootrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.min.css'

import Axios from 'axios'
import md5 from 'js-md5'

// Axios.defaults.headers.post['Content-Type'] = 'application/json'
// Axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*'
Axios.defaults.baseURL = 'http://localhost:8081'

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
