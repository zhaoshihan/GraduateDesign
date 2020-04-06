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
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
</style>
