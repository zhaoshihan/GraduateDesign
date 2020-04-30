const cart = {
  state: {
    status: '',
    cartList: [],
    hasDiscount: false
  },
  mutations: {
    enjoyDiscount (state) {
      state.hasDiscount = true;
    },
    // 添加到购物车
    addCart (state, id) {
      // 先判断购物车是否已有，如果有，数量+1
      const isAdded = state.cartList.find(item => item.id === id);
      if (isAdded) {
        isAdded.count ++;
      } else {
        state.cartList.push({
          id: id,
          count: 1
        })
      }
    },
    // 修改商品数量
    editCartCount (state, payload) {
      const product = state.cartList.find(item => item.id === payload.id);
      product.count += payload.count;
    },
    // 删除商品
    deleteCart (state, id) {
      const index = state.cartList.findIndex(item => item.id === id);
      state.cartList.splice(index, 1);
    },
    // 清空购物车
    emptyCart (state) {
      state.cartList = [];
    }
  },
  actions: {

  },
  getters : {

  }
}

export default cart
