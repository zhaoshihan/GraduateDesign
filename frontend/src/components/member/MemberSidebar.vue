<template>
    <aside class="menu">
        <p class="menu-label">
            会员之家
        </p>
        <ul class="menu-list">
            <li>
                <a>菜单栏</a>
                <ul>
                    <li><a @click="chooseBookDisplay">书籍列表</a></li>
                    <li><a @click="chooseCart">购物车&nbsp;<span v-if="cartList.length" class="tag">{{cartList.length}}</span></a></li>
<!--                    <li><a @click="chooseOwnOrder">订单详情</a></li>-->
                </ul>
            </li>
        </ul>
    </aside>
</template>

<script>
    export default {
        computed: {
            cartList(){
                return this.$store.getters.cartList
            }
        },
        methods:{
            chooseBookDisplay(){
                this.$emit('changeBar', 'BookDisplay')
            },
            chooseCart(){
                this.$emit('changeBar', 'Cart')
            },
            chooseOwnOrder(){
                this.$emit('changeBar', 'OwnOrder')
            }
        }
    }
</script>

<style scoped>
    .tag{
        background-color: #f2352e;
        border: 1px solid #f2352e;
        color: #fff;
    }
</style>
