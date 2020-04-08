<template>
  <div id="home">
<!--    <p>This is home page</p>-->
<!--    <p>current token = {{token}}</p>-->
<!--    <p>current user nickname = {{userNickname}}</p>-->
<!--    <button><router-link to="/ebook">Ebook1</router-link></button>-->

    <header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4 class="text-white">Contact</h4>
              <ul class="list-unstyled">
                <li><a href="#" class="text-white">Follow on Twitter</a></li>
                <li><a href="#" class="text-white">Like on Facebook</a></li>
                <li><a href="#" class="text-white">Email me</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>

      <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <span aria-hidden="true" class="mr-2"><i class="fas fa-book-reader"></i></span>
            <strong>Welcome, {{userNickname}}</strong>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>

    <main role="main">
      <section class="jumbotron text-center">
        <div class="container">
          <h1>Album example</h1>
          <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don’t simply skip over it entirely.</p>
          <p>
            <a href="#" class="btn btn-primary my-2">Main call to action</a>
            <a href="#" class="btn btn-secondary my-2">Secondary action</a>
          </p>
        </div>
      </section>

      <div class="py-5 bg-light">
        <div class="container">
          <div class="row">
              <div class="col-lg-4 col-md-6 mb-4">
                <div class="card h-100">
                  <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                  <div class="card-body">
                    <h4 class="card-title">
                      <a href="#">Item One</a>
                    </h4>
                    <h5>$24.99</h5>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                  </div>
                  <div class="card-footer">
                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                  </div>
                </div>
              </div>
          </div>
        </div>
      </div>

    </main>

    <footer class="text-muted">
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
        <p>Album example is &copy; Bootstrap, but please download and customize it for yourself!</p>
      </div>
    </footer>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  data () {
    return {
      token: '',
      userNickname: ''
    }
  },
  // components: {
  //   HelloWorld
  // }
  mounted () {
    if (window.localStorage.token) {
      this.token = window.localStorage.token
    }
    if (window.localStorage.userNickname) {
      this.userNickname = window.localStorage.userNickname
    }
  }
}
</script>

<style lang="scss" scoped>
  .jumbotron {
    padding-top: 3rem;
    padding-bottom: 3rem;
    margin-bottom: 0;
    background-color: #fff;
  }
  @media (min-width: 768px) {
    .jumbotron {
      padding-top: 6rem;
      padding-bottom: 6rem;
    }
  }

  .jumbotron p:last-child {
    margin-bottom: 0;
  }

  .jumbotron h1 {
    font-weight: 300;
  }

  .jumbotron .container {
    max-width: 40rem;
  }

  footer {
    padding-top: 3rem;
    padding-bottom: 3rem;
  }

  footer p {
    margin-bottom: .25rem;
  }
</style>
