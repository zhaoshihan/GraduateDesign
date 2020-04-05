<template>
  <div class="register">
    <div id="nav">
      <router-link to="/login">Login</router-link> |
      <router-link to="/register">Register</router-link>
    </div>

    <p>Register Vue</p>
    <form :model="registerForm" v-on:submit.prevent>
      <label>Username:</label>
      <input type="text" v-model="registerForm.userName" name="username" id="username">
      <br>
      <p>current username = {{registerForm.userName}}</p>
      <label>Password:</label>
      <input type="password" v-model="registerForm.passWord" name="password" id="password">
      <br>
      <p>current password = {{registerForm.passWord}}</p>
      <label>Nickname:</label>
      <input type="text" v-model="registerForm.nickName" name="nickname" id="nickname">
      <br>
      <p>current nickname = {{registerForm.nickName}}</p>
      <button @click=register>Register</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      registerForm: {
        userName: '',
        passWord: '',
        nickName: ''
      }
    }
  },
  methods: {
    register: function () {
      console.log(this.registerForm)

      this.$axios({
        method: 'post',
        url: '/member/register',
        data: this.registerForm
      }).then(() => {
        alert('register success!')
        this.$router.push('/login')
      }).catch(() => {
        alert('register failed!')
      })
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
