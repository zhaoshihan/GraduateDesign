const user = {
  state: {
    token: '',
    currentUser: null
  },
  mutations: {
    logIn (state, payload) {
      state.currentUser = payload
    },
    logOut (state) {
      state.currentUser = null
    }
  }
}

export default user
