<template>
    <div class="column is-half">
        <div class="card">
<!--            <div class="card-image">-->
<!--                <figure class="image is-3by4">-->
<!--                    <img :src="generatePictureURL" alt="Image">-->
<!--                </figure>-->
<!--            </div>-->
            <div class="card-content">

              <div class="media">
                <div class="media-left">
                  <figure class="image is-3by4" style="width: 96px">
                    <img :src="generatePictureURL" alt="Placeholder image">
                  </figure>
                </div>

                <div class="media-content">
                  <div class="content">
                    <p class="title is-4">{{bookInstance.bookname}}</p>
                    <p class="subtitle is-6">[{{bookInstance.nation}}]&nbsp;&nbsp;{{bookInstance.author}}</p>
                    <p class="is-size-4 has-text-weight-bold">¥ {{bookInstance.price}}</p>
                  </div>
                </div>

                <div class="media-right has-text-centered box">
                  <strong class="is-size-4">{{gradeToRating.toFixed(1)}}</strong>
                  <StarRating :rating="bookInstance.averageGrade" :increment="0.01"
                              :read-only="true" :star-size="16"
                              :show-rating="false"></StarRating>
                  <p class="is-size-7">{{bookInstance.commentNumber}}位用户评价</p>
                </div>
              </div>

              <div class="content">
                {{bookInstance.description}}
              </div>

              <div class="level">
                  <div class="level-item">
                    <button class="button is-info" @click.prevent="jumpToEbook">阅读</button>
                  </div>

                  <div class="level-item" v-if="hasCurrentComment">
                    <UpdateCommentModal
                      :picture-u-r-l="generatePictureURL"
                      :book-instance="bookInstance"></UpdateCommentModal>
                  </div>

                  <div class="level-item" v-else>
                    <AddCommentModal
                      :picture-u-r-l="generatePictureURL"
                      :book-instance="bookInstance"></AddCommentModal>
                  </div>

                  <div class="level-item">
                    <button class="button is-success" @click.prevent="handleAddToCart">加入购物车</button>
                  </div>
              </div>
            </div>
        </div>
    </div>
</template>

<script>
    import StarRating from 'vue-star-rating'
    import AddCommentModal from './AddCommentModal'
    import UpdateCommentModal from './UpdateCommentModal'

    export default {
        props: {
            bookInstance: Object,
        },
        components:{
          AddCommentModal,
          UpdateCommentModal,
          StarRating,
        },
        data () {
            return {
            }
        },
        computed: {
          hasCurrentComment () {
            return this.$store.getters.hasComment(this.getCurrentUserID, this.getCurrentBookID)
          },
          getCurrentComment () {
            return this.$store.getters.comment(this.getCurrentUserID, this.getCurrentBookID)
          },
          getCurrentUserID () {
            const user = this.$store.getters.currentUser
            return user['id']
          },
          getCurrentBookID () {
            return this.bookInstance['id']
          },
          // 将averageGrade转化为10为单位的评分进行显示
          gradeToRating () {
            return this.bookInstance.averageGrade * 2.0;
          },
          // 生成封面png地址
          generatePictureURL () {
            return '/static/images/' + this.bookInstance.bookname + '.jpg'
          }
        },
        methods: {
            // 加入购物车
            handleAddToCart () {
                this.$store.commit('addCart', this.bookInstance.id)
            },
            jumpToEbook () {
              this.$store.commit('enter_current_book', this.bookInstance)
              this.$router.push('/ebook')
            }
        },
    };
</script>

<style scoped>
</style>
