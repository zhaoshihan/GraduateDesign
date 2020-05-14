<template>
<!--  <div class="login">-->
<!--    <div id="nav">-->
<!--      <router-link to="/login">Login</router-link> |-->
<!--      <router-link to="/register">Register</router-link>-->
<!--    </div>-->

<!--    <p>Login Vue</p>-->
<!--    <form>-->
<!--      <label>Username:</label>-->
<!--      <input type="text" v-model="loginForm.username" name="username" id="username">-->
<!--      <br>-->
<!--      <p>current username = {{loginForm.username}}</p>-->
<!--      <label>Password:</label>-->
<!--      <input type="password" v-model="loginForm.password" name="password" id="password">-->
<!--      <br>-->
<!--      <p>current password = {{loginForm.password}}</p>-->

<!--      <div id="example-4">-->
<!--        <input type="radio" id="one" value="One" v-model="loginForm.type">-->
<!--        <label for="one">One</label>-->
<!--        <br>-->
<!--        <input type="radio" id="two" value="Two" v-model="loginForm.type">-->
<!--        <label for="two">Two</label>-->
<!--        <br>-->
<!--        <span>type: {{ loginForm.type }}</span>-->
<!--      </div>-->
<!--      <button v-on:click="login">Login</button>-->
<!--    </form>-->
<!--  </div>-->

  <section class="hero is-success is-fullheight">
    <div class="hero-body">
      <div class="container has-text-centered">
        <div class="column is-4 is-offset-4">
            <div id="nav">
              <router-link to="/login">登陆</router-link> |
              <router-link to="/register">注册</router-link>
            </div>
          <hr class="login-hr">
          <p class="subtitle has-text-black">填写登陆继续</p>
          <div class="box">
<!--            <figure class="avatar">-->
<!--              <img src="https://placehold.it/128x128">-->
<!--            </figure>-->
<!--            <form :model="loginForm" ref="loginForm" v-on:submit.prevent>-->
            <form :model="loginForm" @submit.prevent>
              <div class="field">
                <label class="label has-text-left">用户名：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="loginForm.username" type="text"
                         placeholder="Your username">
                  <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                </div>
<!--                <p>current username = {{loginForm.username}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">密码：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="loginForm.password" type="password"
                         placeholder="Your password">
                  <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                </div>
<!--                <p>current password = {{loginForm.password}}</p>-->
              </div>
              <div class="field">
                <label class="label has-text-left">登陆身份：</label>
                <div class="control">
                  <label class="radio">
                    <input type="radio" v-model="loginForm.type" name="type" value="member">
                    会员
                  </label>
                  <label class="radio">
                    <input type="radio" v-model="loginForm.type" name="type" value="administer">
                    管理员
                  </label>
                </div>
<!--                <p>current type = {{loginForm.type}}</p>-->
              </div>

              <button class="button is-block is-success is-large is-fullwidth" @click="login">登陆</button>
            </form>
          </div>
          <p class="has-text-grey">
            <a href="../">注册</a> &nbsp;·&nbsp;
            <a href="../">忘记密码</a> &nbsp;·&nbsp;
            <a href="../">帮助</a>
          </p>
        </div>
      </div>
    </div>
  </section>

</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: '',
        type: 'member'
      }
    }
  },
  computed: {
    getUsername () {
      return this.loginForm.username
    },
    getPassword () {
      return this.loginForm.password
    },
    getType () {
      return this.loginForm.type
    },
    getPasswordMD5 () {
      return this.$md5(this.getPassword())
    }
  },
  methods: {
    login () {
      this.$store.dispatch('login', this.loginForm)
        .then(() => this.$router.push('/home'))

    }
  }
}
</script>

<style lang="scss" scoped>
  #nav {
    padding: 20px;
    a {
      font-weight: bold;
      font-size: 20px;
      color: #2c3e50;

      &.router-link-exact-active {
        color: #42b983;
      }
    }
  }
  html,body {
    font-family: 'Questrial', sans-serif;
    font-size: 14px;
    font-weight: 300;
  }
  .hero.is-success {
    background: #F2F6FA;
  }
  .hero .nav, .hero.is-success .nav {
    -webkit-box-shadow: none;
    box-shadow: none;
  }
  /*.box {*/
  /*  margin-top: 5rem;*/
  /*}*/
  .avatar {
    margin-top: -70px;
    padding-bottom: 20px;
  }
  .avatar img {
    padding: 5px;
    background: #fff;
    border-radius: 50%;
    -webkit-box-shadow: 0 2px 3px rgba(10,10,10,.1), 0 0 0 1px rgba(10,10,10,.1);
    box-shadow: 0 2px 3px rgba(10,10,10,.1), 0 0 0 1px rgba(10,10,10,.1);
  }
  input {
    font-weight: 300;
  }
  p {
    font-weight: 700;
  }
  /*p.subtitle {*/
  /*  padding-top: 1rem;*/
  /*}*/

  .login-hr{
    border-bottom: 1px solid black;
  }

  .has-text-black{
    color: black;
  }

  .field{
    padding-bottom: 10px;
  }

  .fa{
    margin-left: 5px;
  }
</style>
