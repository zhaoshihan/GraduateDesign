<template>
    <nav class="panel">
        <p class="panel-heading">购物车清单</p>

        <div class="panel-block" v-if="cartList.length">
            <div class="container table-container">
              <table class="table is-fullwidth">
                <thead>
                <tr>
                  <th class="has-text-centered">书籍名称</th>
                  <th class="has-text-centered">书籍单价</th>
                  <th class="has-text-centered">购买数量</th>
                  <th class="has-text-centered">书籍总价</th>
                  <th class="has-text-centered">移出购物车</th>
                </tr>
                </thead>

                <tbody>
                <tr v-for="(item, index) in cartList" :key="item.id">
                  <td class="has-text-centered">
                    <span>{{ bookDictList[item.id].bookname }}</span>
                  </td>
                  <td class="has-text-centered">
                    ¥ {{bookDictList[item.id].price}}
                  </td>
                  <td class="has-text-centered">
                    <a class="tag is-rounded" @click="handleCount(index, -1)">-</a>
                    {{ item.count }}
                    <a class="tag is-rounded" @click="handleCount(index, 1)">+</a>
                  </td>
                  <td class="has-text-centered">
                    ¥ {{ bookDictList[item.id].price * item.count }}
                  </td>
                  <td class="has-text-centered">
                    <a class="button is-danger is-small" @click="handleDelete(index)">删除</a>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
        </div>

        <div class="panel-block">
          <div class="container">
            <nav class="level">
              <div class="level-left" v-if="!cartList.length">
                <div class="level-item">
                  <div class="field">
                    <label class="label">购物车为空</label>
                  </div>
                </div>
              </div>

              <div class="level-left" v-if="cartList.length">
                <div class="level-item">
                  <div class="field">
                    <label class="label">优惠码：</label>
                  </div>
                </div>

                <div class="level-item">
                  <div class="field has-addons">
                    <div class="control">
                      <input class="input" type="text" v-model="promotionCode" placeholder="请输入优惠码">
                    </div>
                    <div class="control">
                      <button class="button is-success" @click="handleCheckCode">检查</button>
                    </div>
                  </div>
                </div>
              </div>


              <div class="level-right">
                <div class="level-item">
                  <p>总共 <span class="tag is-white is-large">{{ countAll }}</span> 件商品</p>
                </div>

                <div class="level-item">
                  <p>
                    总金额 <span class="tag is-white is-large">¥ {{ costAll }}</span>
                    <span v-if="hasDiscount">
                        （折后价格 <span class="tag is-white is-large">¥ {{ discoutCostAll }}</span>）
                  </span>
                  </p>
                </div>

                <div class="level-item">
                  <button v-if="cartList.length" class="button is-info" @click="handleOrder">立即购买</button>
                </div>
              </div>
            </nav>
          </div>
        </div>
    </nav>
</template>
<script>
    export default {
        computed: {
            cartList(){
                return this.$store.getters.cartList
            },
            bookList(){
                return this.$store.getters.bookList
            },
            bookDictList () {
                return this.$store.getters.bookDictList;
            },
            hasDiscount() {
                return this.$store.getters.hasDiscount
            },
            getMemberID() {
                const user = this.$store.getters.currentUser
                return user['id']
            },
            getSendAddress(){
                const user = this.$store.getters.currentUser
                return user['address']
            },
            countAll () {
                let count = 0;
                this.cartList.forEach(item => {
                    count += item.count;
                });
                return count;
            },
            costAll () {
                let cost = 0;
                this.cartList.forEach(item => {
                    cost += this.bookDictList[item.id].price * item.count;
                });
                return cost;
            },
            discoutCostAll(){
                let cost = 0;
                this.cartList.forEach(item =>{
                    cost += this.bookDictList[item.id].price * item.count * 0.8;
                })
                return cost;
            }

        },
        data () {
            return {
              promotionCode: '',
            }
        },
        methods: {
            handleCount (index, count) {
                if (count < 0 && this.cartList[index].count === 1) return;
                this.$store.commit('editCartCount', {
                    id: this.cartList[index].id,
                    count: count
                });
            },
            handleDelete (index) {
                this.$store.commit('deleteCart', this.cartList[index].id);
            },
            handleCheckCode () {
                if (this.promotionCode === '') {
                    window.alert('请输入优惠码');
                    return;
                }
                if (this.promotionCode !== 'Vue.js') {
                    window.alert('优惠码验证失败');
                } else {
                    this.$store.commit('enjoyDiscount')
                }
            },
            handleOrder () {
                // 购买
                this.$store.commit('emptyCart')
                // let requestList = []
                // let timeStamp = (new Date()).valueOf() % 2147483648
                // this.cartList.forEach(item => {
                //     let newInstance = {}
                //     newInstance['id'] = (timeStamp++) % 2147483648
                //     newInstance['productID'] = item.id
                //     newInstance['memberID'] = this.getMemberID
                //     newInstance['orderDate'] = new Date()
                //     newInstance['unitPrice'] = this.productDictList[item.id].price
                //     newInstance['amount'] = item.count
                //     newInstance['sendDate'] = new Date()
                //     newInstance['sendAddress'] = this.getSendAddress
                //     requestList.push(newInstance)
                // });
                // Axios({
                //     method: 'post',
                //     url: '/order/addList',
                //     baseURL: 'http://localhost:8082',
                //     data: requestList
                // }).then(response=> {
                //     console.log("In then method")
                //     console.log(response)
                //     alert("orders add success")
                //     this.$store.commit('emptyCart')
                // }).catch(error=>{
                //     console.warn("In catch method")
                //     console.warn(error)
                //     alert(error)
                // })
            },
        }
    }
</script>

<style scoped>

</style>
