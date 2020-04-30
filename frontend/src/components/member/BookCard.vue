<template>
    <div class="column is-one-third">
        <div class="card">
            <div class="card-image">
                <figure class="image is-4by3">
                    <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Image">
                </figure>
            </div>
            <div class="card-content">
              <div class="media">
                <div class="media-content">
                  <div class="content">
                    <p class="title is-4">{{info.bookname}}</p>
                    <p class="subtitle is-6">[{{info.nation}}]&nbsp;&nbsp;{{info.author}}</p>
                    <p class="is-size-4 has-text-weight-bold">¥ {{info.price}}</p>
                  </div>
                </div>

                <div class="media-right has-text-centered box">
                  <strong>{{info.averageGrade.toFixed(1)}}</strong>
                  <StarRating :rating="gradeToRating" :increment="0.01"
                              :read-only="true" :star-size="12"
                              :show-rating="false"></StarRating>
                  <p class="is-size-7">{{info.commentNumber}}位用户评价</p>
                </div>
              </div>

              <div class="content">
                {{info.description}}
                <br>
                <time datetime="2016-1-1">11:09 PM - 1 Jan 2016</time>
              </div>

              <div class="level">
                  <div class="level-left level-item">
                      <button class="button is-primary">阅读</button>
                  </div>
                  <div class="level-right level-item">
                      <button class="button is-success" @click.prevent="handleAddToCart">加入购物车</button>
                  </div>
              </div>
<!--                <ul style="list-style:none">-->
<!--                    <li class="title is-4">{{info.bookname}}</li>-->
<!--                    <li class="subtitle is-6">¥ {{info.price}}</li>-->
<!--                    <li class="subtitle is-6">{{info.category}}</li>-->
<!--                    <li class="subtitle is-6">{{info.nation}}</li>-->
<!--                    <li>-->
<!--                        <div class="level">-->
<!--                            <div class="level-left level-item">-->
<!--&lt;!&ndash;                                <detail-modal :instance="info"></detail-modal>&ndash;&gt;-->
<!--                                <button class="button is-primary">阅读</button>-->
<!--                            </div>-->
<!--                            <div class="level-right level-item">-->
<!--                                <button class="button is-success" @click.prevent="handleAddToCart">加入购物车</button>-->
<!--                            </div>-->
<!--                        </div>-->
<!--                    </li>-->
<!--                </ul>-->
            </div>
        </div>
    </div>
</template>

<script>
    // import detailModal from '../common/DetailsModal'
    import StarRating from 'vue-star-rating'
    export default {
        props: {
            info: Object,
        },
        components:{
          // detailModal,
          StarRating
        },
        data () {
            return {
            }
        },
        computed: {
          // 将averageGrade转化为5为单位的rating
          gradeToRating: function () {
            return this.info.averageGrade / 2.0;
          }
        },
        methods: {
            // 加入购物车
            handleAddToCart () {
                this.$store.commit('addCart', this.info.id);
            }
        }
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
