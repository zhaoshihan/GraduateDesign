<template>
  <div class="login">
    <div id="nav">
      <router-link to="/login">Login</router-link> |
      <router-link to="/register">Register</router-link>
    </div>

    <p>Login Vue</p>
    <form v-bind:model="loginForm" v-on:submit.prevent>
      <label>Username:</label>
      <input type="text" v-model="loginForm.userName" name="username" id="username">
      <br>
      <p>current username = {{loginForm.userName}}</p>
      <label>Password:</label>
      <input type="password" v-model="loginForm.passWord" name="password" id="password">
      <br>
      <p>current password = {{loginForm.passWord}}</p>
      <button v-on:click="login">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        userName: '',
        passWord: ''
      }
    }
  },
  computed: {
    getUserName () {
      return this.loginForm.userName
    },
    getPassWord () {
      return this.loginForm.passWord
    },
    getPasswordMD5 () {
      return this.$md5(this.getPassWord())
    }
  },
  methods: {
    login: function () {
      console.log(this.loginForm)

      this.$axios({
        method: 'post',
        url: '/member/login',
        data: this.loginForm
      }).then(response => {
        console.log(response.data)
        // this.$store.commit('logIn', response.data)
        window.localStorage.token = response.data.token
        window.localStorage.userNickname = response.data.userNickname
        this.$router.push('/home')
      })

      // Axios({
      //   method: 'post',
      //   url: tmpUrl,
      //   baseURL: 'http://localhost:8082',
      //   auth: {
      //     username: this.getAccount,
      //     password: this.getPassword,
      //   },
      //   // params: this.loginForm
      // }).then(response=> {
      //   console.log("In then method")
      //   console.log(response.data)
      //   if(this.getPicked === 'member'){
      //     this.$store.commit('memberLogin', response.data)
      //     this.$router.push('/member_home')
      //   }
      //   else if(this.getPicked === 'staff'){
      //     this.$store.commit('staffLogin', response.data)
      //     this.$router.push('/staff_home')
      //   }
      // }).catch(error=>{
      //   console.warn("In catch method")
      //   console.warn(error)
      //   alert(error)
      // })
    }
  }
}
</script>

<style lang="scss" scoped>
  #nav {
    padding: 30px;

    a {
      font-weight: bold;
      color: #2c3e50;

      &.router-link-exact-active {
        color: #42b983;
      }
    }
  }
</style>
