import axios from 'axios'

// 数组排重
function getFilterArray (array) {
  const res = [];
  const json = {};
  for (let i = 0; i < array.length; i++){
    const _self = array[i];
    if(!json[_self]){
      res.push(_self);
      json[_self] = 1;
    }
  }
  return res;
}

const book = {
  state: {
    status: '',
    bookList: [],
    currentBook: null
  },
  mutations: {
    booklist_request (state) {
      state.status = 'loading'
    },
    // 添加书籍列表
    booklist_success (state, payload) {
      state.status = 'success'
      state.bookList = payload;
    },
    booklist_error (state) {
      state.status = 'error'
      state.bookList = []
    },

    enter_current_book (state, payload) {
      state.currentBook = payload
    },
    exist_current_book (state) {
      state.currentBook = null
    }
  },
  actions: {
    // 请求书籍列表
    getBookList ({ commit }) {
      return new Promise((resolve, reject) => {
        commit('booklist_request')
        axios({
          method: 'GET',
          url: '/book/all',
        }).then(response => {
          // console.log(response.data)
          commit('booklist_success', response.data)

          resolve(response)
        }).catch(error => {
          commit('booklist_error', error)

          reject(error)
        })
      })
    },
  },
  getters: {
    categories: state => {
      const categories = state.bookList.map(item => item.category);
      return getFilterArray(categories);
    },
    nations: state => {
      const nations = state.bookList.map(item => item.nation);
      return getFilterArray(nations);
    },
    bookDictList: state => {
      const dict = {};
      state.bookList.forEach(item => {
        dict[item.id] = item;
      });
      return dict;
    },
    bookList: state => state.bookList,
    currentBook: state => state.currentBook
  },
}

export default book
