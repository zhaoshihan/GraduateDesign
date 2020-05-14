import axios from 'axios'

const comment = {
  state: {
    status: '',
    commentList: [],
  },
  mutations: {
    comment_request (state) {
      state.status = 'loading'
    },
    comment_add_success (state) {
      state.status = 'add_success'
    },
    comment_add_error (state) {
      state.status = 'add_error'
    },
    comment_get_success (state, payload) {
      state.status = 'get_success'
      state.commentList = payload
    },
    comment_get_error (state) {
      state.status = 'get_error'
    }
  },
  actions: {
    addComment ({ commit }, commentForm) {
      return new Promise((resolve, reject) => {
        commit('comment_request')
        axios({
          method: 'POST',
          url: '/comment',
          data: commentForm
        }).then(resp => {

          commit('comment_add_success')

          resolve(resp)
        }).catch(err => {
          commit('comment_add_error')

          reject(err)
        })
      })
    },
    getCommentListByUser ({commit}, userID) {
      return new Promise((resolve, reject) => {
        commit('comment_request')
        axios({
          method: 'GET',
          url: '/comment/' + userID
        }).then(response => {

          commit('comment_get_success', response.data)

          resolve(response)
        }).catch(error => {

          commit('comment_get_error')

          reject(error)
        })
      })
    }
  },
  getters: {
    commentList: state => state.commentList,
    hasCommentList: state => state.commentList.length !== 0 || state.status === 'get_success',
    comment: state => (userID, bookID) => {
      return state.commentList.find(item => item.bookID === bookID && item.memberID === userID)
    },
    hasComment: state => (userID, bookID) => {
      const res = state.commentList.find(item => item.bookID === bookID && item.memberID === userID)
      return !!res
    }
  }

}

export default comment
