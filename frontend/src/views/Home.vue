<template>
<!--  <div id="home">-->
<!--    <p>This is home page</p>-->
<!--    <p>current token = {{token}}</p>-->
<!--    <p>current user nickname = {{nickname}}</p>-->
<!--    <button><router-link to="/ebook">Ebook1</router-link></button>-->
<!--  </div>-->

  <div class="container">
    <Navbar></Navbar>

<!--    <div class="columns">-->
<!--      <div class="column is-one-fifth">-->
<!--        <side-bar @changeBar="handleChangeBar"></side-bar>-->
<!--      </div>-->
<!--      <div class="column">-->
<!--        <component :is="currentView"></component>-->
<!--      </div>-->
<!--    </div>-->
  </div>
</template>

<script>
// @ is an alias to /src
import Navbar from '../components/common/Navbar'

export default {
  name: 'Home',
  components: { Navbar },
  data () {
    return {
      token: '',
      nickname: ''
    }
  },
  computed: {
    isLoggedIn: function () {
      return this.$store.getters.isLoggedIn
    }
  },
  mounted () {
    // if (window.localStorage.token) {
    //   this.token = window.localStorage.token
    // }
    // if (window.localStorage.userNickname) {
    //   this.nickname = window.localStorage.nickname
    // }
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
