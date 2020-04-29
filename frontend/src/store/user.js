import axios from 'axios'

const user = {
  state: {
    status: '',
    token: localStorage.getItem('token') || '',
    currentUser: {},
    // currentUser 结构: {
    //   id: null,
    //   nickname: null,
    //   gender: null,
    //   city: null,
    //   address: null,
    //   phoneNumber: null,
    //   postcode: null,
    //   email: null
    // }
  },
  mutations: {
    auth_request (state) {
      state.status = 'loading'
    },
    auth_success (state, payload) {
      state.status = 'success'
      state.token = payload.token
      state.currentUser = payload.user
    },
    auth_error (state) {
      state.status = 'error'
    },
    logout (state) {
      state.status = ''
      state.token = ''
      state.currentUser = {}
    },
  },
  actions: {
    login ({ commit }, loginForm) {
      return new Promise((resolve, reject) => {
        commit('auth_request')
        axios({
          method: 'POST',
          url: '/member/login',
          data: {
            username: loginForm.username,
            password: loginForm.password
          }
        }).then(resp => {
          const token = resp.data.token
          const user = resp.data.user

          // 使用localstorage存储而不是直接存储在Vuex中是为了浏览器刷新页面
          // 以及关闭后再打开页面还能正确登陆
          localStorage.setItem('token', token)
          // localStorage.setItem('currentUser', user)

          // Add the following line:
          axios.defaults.headers.common['Authorization'] = token
          commit('auth_success', {
            token: token,
            user: user
          })
          resolve(resp)
        }).catch(err => {
          commit('auth_error')
          localStorage.removeItem('token')
          // localStorage.removeItem('currentUser')
          reject(err)
        })
      })
    },
    register ({ commit }, registerForm) {
      return new Promise((resolve, reject) => {
        commit('auth_request')
        axios({
          method: 'POST',
          url: '/member/register',
          data: registerForm
        }).then(resp => {
          // const token = resp.data.token
          // const user = resp.data.user
          // localStorage.setItem('token', token)
          // // Add the following line:
          // axios.defaults.headers.common['Authorization'] = token
          // commit('auth_success', token, user)
          resolve(resp)
        }).catch(err => {
          commit('auth_error', err)
          localStorage.removeItem('token')
          // localStorage.removeItem('currentUser')
          reject(err)
        })
      })
    },
    logout ({ commit }) {
      return new Promise((resolve, reject) => {
        commit('logout')
        localStorage.removeItem('token')
        // localStorage.removeItem('currentUser')
        delete axios.defaults.headers.common['Authorization']
        resolve()
      })
    }
  },
  getters: {
    isLoggedIn: state => !!state.token,
    authStatus: state => state.status,
    getNickname: state => state.currentUser['nickname']
  }
}

export default user
