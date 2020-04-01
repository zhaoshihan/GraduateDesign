<template>
  <div class="home">
    <p>This is home page</p>
    <p>current token = {{token}}</p>
    <p>current user nickname = {{userNickname}}</p>

    <img alt="Vue logo" src="../assets/logo.png">
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  data () {
    return {
      token: '',
      userNickname: ''
    }
  },
  // components: {
  //   HelloWorld
  // }
  mounted () {
    if (window.localStorage.token) {
      this.token = window.localStorage.token
    }
    if (window.localStorage.userNickname) {
      this.userNickname = window.localStorage.userNickname
    }
  }
}
</script>

<style scoped lang="css">

</style>
