<template>
  <div id="app">
<!--    <div id="nav">-->
<!--      <router-link to="/login">Login</router-link> |-->
<!--      <router-link to="/register">Register</router-link>-->
<!--    </div>-->

    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',

  created: function () {
    // this.$axios.interceptors.response.use(undefined, function (error) {
    //   return new Promise(function (resolve, reject) {
    //     // token过期时的处理, 触发logout action(在store/user.js中), 返回'/login'页面
    //     console.log('in token interceptor')
    //     console.log('error status = ' + error.status)
    //     console.log('error config = ' + error.config)
    //     if (error.status === 401 && error.config && !error.config.__isRetryRequest) {
    //       alert('token interceptor: the token is expired!')
    //       this.$store.dispatch('logout')
    //     }
    //     throw error;
    //   });
    // });
  }

}
// document.addEventListener('DOMContentLoaded', () => {
//   const html = document.querySelector('html')
//   let fontSize = window.innerWidth / 10
//   fontSize = fontSize > 50 ? 50 : fontSize
//   html.style.fontSize = fontSize + 'px'
// })
</script>

<style lang="scss">
  #app {
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
    margin: 0;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: left;
    background-color: #fff;
  }
</style>
