<template>
  <div id="home">
    <p>This is home page</p>
    <p>current token = {{token}}</p>
    <p>current user nickname = {{nickname}}</p>
    <button><router-link to="/ebook">Ebook1</router-link></button>

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
      nickname: ''
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
      this.nickname = window.localStorage.nickname
    }
  }
}
</script>

<style lang="scss" scoped>
  .jumbotron {
    padding-top: 3rem;
    padding-bottom: 3rem;
    margin-bottom: 0;
    background-color: #fff;
  }
  @media (min-width: 768px) {
    .jumbotron {
      padding-top: 6rem;
      padding-bottom: 6rem;
    }
  }

  .jumbotron p:last-child {
    margin-bottom: 0;
  }

  .jumbotron h1 {
    font-weight: 300;
  }

  .jumbotron .container {
    max-width: 40rem;
  }

  footer {
    padding-top: 3rem;
    padding-bottom: 3rem;
  }

  footer p {
    margin-bottom: .25rem;
  }
</style>
