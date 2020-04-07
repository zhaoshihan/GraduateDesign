<template>
<!--  <div class="register">-->
<!--    <div id="nav">-->
<!--      <router-link to="/login">Login</router-link> |-->
<!--      <router-link to="/register">Register</router-link>-->
<!--    </div>-->

<!--    <p>Register Vue</p>-->
<!--    <form :model="registerForm" v-on:submit.prevent>-->
<!--      <label>Username:</label>-->
<!--      <input type="text" v-model="registerForm.userName" name="username" id="username">-->
<!--      <br>-->
<!--      <p>current username = {{registerForm.userName}}</p>-->
<!--      <label>Password:</label>-->
<!--      <input type="password" v-model="registerForm.passWord" name="password" id="password">-->
<!--      <br>-->
<!--      <p>current password = {{registerForm.passWord}}</p>-->
<!--      <label>Nickname:</label>-->
<!--      <input type="text" v-model="registerForm.nickName" name="nickname" id="nickname">-->
<!--      <br>-->
<!--      <p>current nickname = {{registerForm.nickName}}</p>-->
<!--      <button @click=register>Register</button>-->
<!--    </form>-->
<!--  </div>-->

  <div class="container text-center">
    <div class="row justify-content-center align-items-center" style="height:100vh">
      <div class="col-4">
        <div id="nav">
          <router-link to="/login">Login</router-link> |
          <router-link to="/register">Register</router-link>
        </div>
        <div class="card">
          <div class="card-header">
            <h3 class="h3 mb-3 font-weight-normal">Please register</h3>
          </div>
          <div class="card-body">
            <form :model="registerForm" @submit.prevent>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="text" class="form-control" v-model="registerForm.userName" placeholder="username">
              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-lock"></i></span>
                </div>
                <input type="password" class="form-control" v-model="registerForm.passWord" placeholder="password">
              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                </div>
                <input type="text" class="form-control" v-model="registerForm.nickName" placeholder="nickname">
              </div>
              <div class="form-group">
                <button class="btn btn-lg btn-primary btn-block" @click="register">Register</button>
              </div>
            </form>
          </div>
          <div class="card-footer">
            <span class="mt-5 mb-3 text-muted">&copy; 2017-2020</span>
          </div>
        </div>
      </div>
    </div>
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
