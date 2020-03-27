<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
<!--    <form>-->
<!--      <div class="form-group">-->
<!--        <label for="exampleInputEmail1">Email address</label>-->
<!--        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">-->
<!--        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
<!--      </div>-->
<!--      <div class="form-group">-->
<!--        <label for="exampleInputPassword1">Password</label>-->
<!--        <input type="password" class="form-control" id="exampleInputPassword1">-->
<!--      </div>-->
<!--      <div class="form-group form-check">-->
<!--        <input type="checkbox" class="form-check-input" id="exampleCheck1">-->
<!--        <label class="form-check-label" for="exampleCheck1">Check me out</label>-->
<!--      </div>-->
<!--      <button type="submit" class="btn btn-primary">Submit</button>-->
<!--    </form>-->
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>

<style scoped lang="css">

</style>
