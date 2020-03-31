const user = {
  state: {
    token: null,
    userNickname: null
  },
  mutations: {
    logIn (state, payload) {
      state.token = payload.token
      state.userNickname = payload.userNickname
    },
    logOut (state) {
      state.token = null
      state.userNickname = null
    }
  }
}

export default user
