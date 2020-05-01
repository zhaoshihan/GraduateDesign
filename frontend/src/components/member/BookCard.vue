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
                  <figure class="image is-64x64">
                    <img :src="generatePictureURL" alt="Placeholder image">
                  </figure>
                </div>

                <div class="media-content">
                  <div class="content">
                    <p class="title is-4">{{info.bookname}}</p>
                    <p class="subtitle is-6">[{{info.nation}}]&nbsp;&nbsp;{{info.author}}</p>
                    <p class="is-size-4 has-text-weight-bold">¥ {{info.price}}</p>
                  </div>
                </div>

                <div class="media-right has-text-centered box">
                  <strong class="is-size-4">{{info.averageGrade.toFixed(1)}}</strong>
                  <StarRating :rating="gradeToRating" :increment="0.01"
                              :read-only="true" :star-size="16"
                              :show-rating="false"></StarRating>
                  <p class="is-size-7">{{info.commentNumber}}位用户评价</p>
                </div>
              </div>

              <div class="content">
                {{info.description}}
              </div>

              <div class="level">
                  <div class="level-left level-item">
                      <button class="button is-info" @click.prevent="jumpToEbook">阅读</button>
<!--                    <ReaderModal :book-instance="info"></ReaderModal>-->
                  </div>
                  <div class="level-right level-item">
                      <button class="button is-success" @click.prevent="handleAddToCart">加入购物车</button>
                  </div>
              </div>
            </div>
        </div>
    </div>
</template>

<script>
    // import detailModal from '../common/DetailsModal'
    import StarRating from 'vue-star-rating'
    // import ReaderModal from './ReaderModal'

    export default {
        props: {
            info: Object,
        },
        components:{
          // detailModal,
          StarRating,
          // ReaderModal
        },
        data () {
            return {
            }
        },
        computed: {
          // 将averageGrade转化为5为单位的rating
          gradeToRating () {
            return this.info.averageGrade / 2.0;
          },
          // 生成封面png地址
          generatePictureURL () {
            return '/static/images/' + this.info.bookname + '.jpg'
          }
        },
        methods: {
            // 加入购物车
            handleAddToCart () {
                this.$store.commit('addCart', this.info.id)
            },
            jumpToEbook () {
              this.$store.commit('enter_current_book', this.info)
              this.$router.push('/ebook')
            }
        },
    };
</script>

<style scoped>
.custom-text {
  font-weight: bold;
  font-size: 1.9em;
  border: 1px solid #cfcfcf;
  padding-left: 10px;
  padding-right: 10px;
  border-radius: 5px;
  color: #999;
  background: #fff;
}
</style>
