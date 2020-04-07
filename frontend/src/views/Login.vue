<template>
  <div class="container text-center">
    <div class="row justify-content-center align-items-center" style="height:100vh">
      <div class="col-4">
        <div id="nav">
          <router-link to="/login">Login</router-link> |
          <router-link to="/register">Register</router-link>
        </div>
        <div class="card">
          <div class="card-header">
            <h3 class="h3 mb-3 font-weight-normal">Please sign in</h3>
          </div>
          <div class="card-body">
            <form :model="loginForm" @submit.prevent>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="text" class="form-control" v-model="loginForm.userName" placeholder="username">
              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-lock"></i></span>
                </div>
                <input type="password" class="form-control" v-model="loginForm.passWord" placeholder="password">
              </div>
              <div class="form-group">
                <div class="checkbox mb-3">
                  <label>
                    <input type="checkbox" value="remember-me"> Remember me
                  </label>
                </div>
              </div>
              <div class="form-group">
                <button class="btn btn-lg btn-primary btn-block" @click="login">Sign in</button>
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
