<template>
  <section>
    <button class="button is-danger" @click="showModal">查看评论</button>

    <div class="modal" v-if="showModalFlag" :class="{'is-active': showModalFlag}">
      <div class="modal-background"></div>
      <div class="modal-card">
        <header class="modal-card-head">
          <p class="modal-card-title">查看您的评论</p>


          <button class="button is-primary" @click="changeMode">{{getButtonMessage}}</button>

          <button class="delete" aria-label="close" @click="cancelModal">></button>
        </header>
        <section class="modal-card-body">

          <form v-if="!isEditMode" @submit.prevent>
            <div class="field">
              <label class="label">评分</label>
              <div class="control">
                <StarRating :rating="comment.grade"
                            :read-only="true"
                            textClass="custom-text"></StarRating>
              </div>
            </div>
            <div class="field">
              <label class="label">评论</label>
              <div class="control">
                <p>{{comment.content}}</p>
              </div>
            </div>
          </form>

          <form v-if="isEditMode" :model="commentForm" @submit.prevent>
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

              <p>current bookID = {{comment.bookID}}</p>
              <p>current memberID = {{comment.memberID}}</p>
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
    name: 'UpdateCommentModal',
    components: {StarRating},
    props: {
      comment:Object
    },
    data () {
      return {
        showModalFlag: false,
        okPressed: false,
        isEditMode: false,

        commentForm: {
          content: this.comment.content,
          grade: this.comment.grade
        }
      }
    },
    computed: {
      getButtonMessage () {
        return this.isEditMode ? '切换查看' : '切换编辑'
      }
    },
    methods: {
      showModal () {
        this.okPressed = false;
        this.showModalFlag = true;
      },
      okModal () {
        // this.$store.dispatch('addComment', {
        //   content: this.commentForm.content,
        //   grade: this.commentForm.grade,
        //   memberID: this.getCurrentUserID,
        //   bookID: this.getCurrentBookID
        // }).then(() => {
        //   alert('add comment success')
        // })

        this.okPressed = true;
        this.showModalFlag = false;
      },
      cancelModal () {
        this.okPressed = false;
        this.showModalFlag = false;
      },
      changeMode () {
        this.isEditMode = !this.isEditMode;
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
