<template>
  <nav class="navbar is-transparent">
    <div class="navbar-brand">
      <a class="navbar-item" href="https://bulma.io">
        <img src="https://bulma.io/images/bulma-logo.png" alt="Bulma: a modern CSS framework based on Flexbox" width="112" height="28">
      </a>
    </div>

    <div id="navbarExampleTransparentExample" class="navbar-menu">
      <div class="navbar-start">
        <a class="navbar-item" href="https://bulma.io/">
          Home
        </a>

        <a class="navbar-item" href="#">
          Docs
        </a>

        <a class="navbar-item" href="#">
          Picture
        </a>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <p class="subtitle" v-cloak>Welcome, {{ nickname }}</p>

<!--        <p class="subtitle">Welcome, </p>-->
      </div>
      <div class="navbar-item">
        <a class="button is-primary">
          <strong @click="logout">Log Out</strong>
        </a>
      </div>
    </div>
  </nav>
</template>

<script>
  export default {
    name: 'Navbar',
    mounted: function () {
      if (!this.hasCurrentUser) {
        this.$store.dispatch('regetUser')
      }
    },
    computed: {
      hasCurrentUser: function () {
        return this.$store.getters.hasCurrentUser
      },
      nickname: function () {
        let user = this.$store.getters.getCurrentUser
        if (user) return user['nickname']
        else return ''
      }
    },
    methods: {
      logout: function () {
        this.$store.dispatch('logout')
          .then(() => {
            this.$router.push('/login')
          })
      }
    }
  }
</script>

<style scoped>

</style>
