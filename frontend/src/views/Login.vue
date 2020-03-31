<template>
  <form v-bind:model="loginForm" v-on:submit.prevent>
    <label>Username:</label>
    <input type="text" v-model="loginForm.userName" name="username" id="username">
    <br>
    <p>current username = {{loginForm.userName}}</p>
    <label>Password:</label>
    <input type="password" v-model="loginForm.passWord" name="password" id="password">
    <br>
    <p>current password = {{loginForm.passWord}}</p>
    <button v-on:click="login">submit</button>
  </form>
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
        params: this.loginForm
        // data: this.loginForm
      }).then(response => {
        console.log(response.data)
        this.$store.commit('logIn', response.data)
        this.$router.push('/home')
      }).catch(error => {
        console.warn('in catch method')
        console.warn(error)
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

<style scoped>

</style>
