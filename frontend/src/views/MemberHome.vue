<template>
<!--  <div id="home">-->
<!--    <p>This is home page</p>-->
<!--    <p>current token = {{token}}</p>-->
<!--    <p>current user nickname = {{nickname}}</p>-->
<!--    <button><router-link to="/ebook">Ebook1</router-link></button>-->
<!--  </div>-->

  <div class="container">
    <Navbar></Navbar>

    <div class="columns">
      <div class="column is-one-fifth">
        <Sidebar @changeBar="handleChangeBar"></Sidebar>
      </div>
      <div class="column">
        <component :is="currentView"></component>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Navbar from '../components/common/Navbar'
import Sidebar from '../components/member/MemberSidebar'
import BookDisplay from '../components/member/BookDisplay'
import Cart from '../components/member/Cart'
// import OwnOrder from '../components/member/OwnOrder'

export default {
  name: 'Home',
  // beforeCreate () {
  //   if (!this.hasCurrentUser) {
  //     this.$store.dispatch('regetUser')
  //   }
  // },
  components: {
    Navbar,
    Sidebar,
    BookDisplay,
    Cart,
    // OwnOrder,
  },
  data () {
    return {
      // token: '',
      // nickname: ''
      currentView: 'BookDisplay'
    }
  },
  computed: {
    // isLoggedIn () {
    //   return this.$store.getters.isLoggedIn
    // },
    hasCurrentUser () {
      return this.$store.getters.hasCurrentUser
    }
  },
  methods: {
    handleChangeBar (name) {
      this.currentView = name;
    },
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
