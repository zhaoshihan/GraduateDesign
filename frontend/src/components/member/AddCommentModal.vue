<template>
  <section>
<!--    <button v-if="hasCurrentComment" class="button is-danger">查看评论</button>-->
<!--    <button v-if="!hasCurrentComment" class="button is-warning" @click="showModal">写评论</button>-->
    <button class="button is-warning" @click="showModal">写评论</button>

    <div class="modal" v-if="showModalFlag" :class="{'is-active': showModalFlag}">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">写下您的评论</p>
          <button class="delete" aria-label="close" @click="cancelModal">></button>
        </header>
        <section class="modal-card-body">
          <form :model="commentForm" @submit.prevent>
            <div class="field">
              <label class="label">评分</label>
              <div class="control">
                <StarRating v-model="commentForm.grade" textClass="custom-text"></StarRating>
              </div>
              <p>current grade = {{commentForm.grade}}</p>
            </div>

            <div class="field">
              <label class="label">评论</label>
              <div class="control">
                <textarea class="textarea" v-model="commentForm.content"
                          placeholder="说说你读过之后的感受吧..."></textarea>
              </div>
              <p>current content = {{commentForm.content}}</p>
              <p>current bookID = {{bookID}}</p>
              <p>current memberID = {{memberID}}</p>
            </div>
          </form>
        </section>
        <footer class="modal-card-foot">
          <button class="button is-success" @click="okModal">提交</button>
          <button class="button" @click="cancelModal">取消</button>
        </footer>
      </div>
    </div>
  </section>
</template>

<script>
  import StarRating from 'vue-star-rating'

  export default {
    name: 'AddCommentModal',
    components: { StarRating },
    props: {
      bookID: Number,
      memberID: Number,
    },
    data() {
      return {
        showModalFlag: false,
        okPressed: false,
        // message: "Press 'Ok' or 'Cancel'.",
        commentForm: {
          content: '',
          grade: 0
        }
      }
    },
    computed: {
      // getCurrentUserID () {
      //   const user = this.$store.getters.currentUser
      //   return user['id']
      // },
      // getCurrentBookID () {
      //   return this.bookInstance['id']
      // }
    },
    methods: {
      showModal () {
        this.okPressed = false;
        this.showModalFlag = true;
      },
      okModal () {
        this.$store.dispatch('addComment', {
          content: this.commentForm.content,
          grade: this.commentForm.grade,
          memberID: this.memberID,
          bookID: this.bookID
        }).then(() => {
            alert('add comment success')
          })

        this.okPressed = true;
        this.showModalFlag = false;
      },
      cancelModal () {
        this.okPressed = false;
        this.showModalFlag = false;
      }
    }
  }
</script>

<style scoped>
  /*使用/deep/使得scoped作用域的父组件能够改变子组件的style*/
   >>> .custom-text {
     font-weight: bold;
     font-size: 2em;
     border: 1px solid #cfcfcf;
     padding-left: 10px;
     padding-right: 10px;
     border-radius: 5px;
     color: #999;
     background: #fff;
  }
</style>
