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
  name: 'App'
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
