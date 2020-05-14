import Vue from 'vue'
import Vuex from 'vuex'

import user from '@/store/user'
import book from '@/store/book'
import cart from '@/store/cart'
import comment from '@/store/comment'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user,
    book,
    cart,
    comment
  }
})
