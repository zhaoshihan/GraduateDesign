<template>
  <section class="hero is-success is-fullheight">
    <div class="hero-body">
      <div class="container has-text-centered">
        <div class="column is-4 is-offset-4">
          <div id="nav">
            <router-link to="/login">登陆</router-link> |
            <router-link to="/register">注册</router-link>
          </div>
          <hr class="login-hr">
          <p class="subtitle has-text-black">填写注册继续</p>
          <div class="box">
            <!--            <figure class="avatar">-->
            <!--              <img src="https://placehold.it/128x128">-->
            <!--            </figure>-->
            <form :model="registerForm" @submit.prevent>
              <div class="field">
                <label class="label has-text-left">用户名：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.username" type="text"
                         placeholder="Your username">
                  <span class="icon is-small is-left"><i class="fas fa-user"></i></span>
                </div>
<!--                <p>current username = {{registerForm.username}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">密码：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.password" type="password"
                         placeholder="Your password">
                  <span class="icon is-small is-left"><i class="fas fa-lock"></i></span>
                </div>
<!--                <p>current password = {{registerForm.password}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">昵称：</label>
                <p class="control has-icons-left">
                  <input class="input" v-model="registerForm.nickname" type="text"
                         placeholder="Your nickname">
                  <span class="icon is-small is-left"><i class="fas fa-user-tag"></i></span>
                </p>
<!--                <p>current nickname = {{registerForm.nickname}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">性别：</label>
                <div class="control">
                  <label class="radio">
                    <input type="radio" v-model="registerForm.gender" name="gender" value="男">
                    男
                  </label>
                  <label class="radio">
                    <input type="radio" v-model="registerForm.gender" name="gender" value="女">
                    女
                  </label>
                </div>
<!--                <p>current gender = {{registerForm.gender}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">城市：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.city" type="text"
                         placeholder="Your city">
                  <span class="icon is-small is-left"><i class="fas fa-city"></i></span>
                </div>
<!--                <p>current city = {{registerForm.city}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">地址：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.address" type="text"
                         placeholder="Your address">
                  <span class="icon is-small is-left"><i class="fas fa-road"></i></span>
                </div>
<!--                <p>current address = {{registerForm.address}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">邮政编码：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.postcode" type="text"
                         placeholder="Your postcode">
                  <span class="icon is-small is-left"><i class="fas fa-envelope"></i></span>
                </div>
<!--                <p>current postcode = {{registerForm.postcode}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">手机号码：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.phoneNumber" type="text"
                         placeholder="Your phone number">
                  <span class="icon is-small is-left"><i class="fas fa-mobile-alt"></i></span>
                </div>
<!--                <p>current phoneNumber = {{registerForm.phoneNumber}}</p>-->
              </div>

              <div class="field">
                <label class="label has-text-left">邮箱：</label>
                <div class="control has-icons-left">
                  <input class="input" v-model="registerForm.email" type="email"
                         placeholder="Your email">
                  <span class="icon is-small is-left"><i class="fas fa-at"></i></span>
                </div>
<!--                <p>current email = {{registerForm.email}}</p>-->
              </div>

              <button class="button is-block is-primary is-large is-fullwidth" @click="register">注册</button>
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
  name: 'Register',
  data () {
    return {
      registerForm: {
        username: '',
        password: '',
        nickname: '',
        gender: '男',
        city: '',
        address: '',
        postcode: '',
        phoneNumber: '',
        email: ''
      }
    }
  },
  methods: {
    register: function () {
      this.$store.dispatch('register', this.registerForm)
        .then(() => {
          alert('register success!')
          this.$router.push('/login')
        })
        .catch(() => {
          alert('register failed!')
        })
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
