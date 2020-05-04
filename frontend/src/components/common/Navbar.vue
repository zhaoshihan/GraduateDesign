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
          主页
        </a>

        <a class="navbar-item" href="#">
          文档
        </a>

        <a class="navbar-item" href="#">
          图片
        </a>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <p class="subtitle" v-cloak>欢迎你, {{ nickname }}</p>

<!--        <p class="subtitle">Welcome, </p>-->
      </div>
      <div class="navbar-item">
        <a class="button is-primary">
          <strong @click="logout">注销</strong>
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
        let user = this.$store.getters.currentUser
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
