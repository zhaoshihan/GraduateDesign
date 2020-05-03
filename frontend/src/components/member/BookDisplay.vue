<template>
    <div class="product-display">
        <div class="section">
            <div class="container">
<!--              <p>certain book name = {{certainBookName}}</p>-->
                <div class="field is-grouped">

                  <p class="control has-icons-left">
                    <input class="input" type="text" placeholder="输入书名"
                           v-model="certainBookName">
                    <span class="icon is-left"><i class="fas fa-search" aria-hidden="true"></i></span>
                  </p>
                  <p class="control">
                    <a class="button is-info">搜索</a>
                  </p>
                </div>

                <div class="field">
                    <div class="tags are-medium">
                      <span class="tag is-white">书籍类型：</span>
                      <a
                          class="tag"
                          :class="{on: item === filterCategory}"
                          v-for="item in categories"
                          @click="handleFilterCategory(item)">{{ item }}</a>
                    </div>
                </div>
                <div class="field">
                    <div class="tags are-medium">
                        <span class="tag is-white">所属国家：</span>
                        <a
                          class="tag"
                          :class="{on: item === filterNation}"
                          v-for="item in nations"
                          @click="handleFilterNation(item)">{{ item }}</a>
                    </div>
                </div>
                <div class="field">
                    <div class="tags are-medium">
                        <span class="tag is-white">智能排行：</span>
                        <a
                          class="tag"
                          :class="{on: order === ''}"
                          @click="handleOrderDefault">默认</a>
                        <a
                          class="tag"
                          :class="{on: order.indexOf('grade') > -1}"
                          @click="handleOrderGrade">
                          评价
                          <template v-if="order === 'grade-asc'">↑</template>
                          <template v-if="order === 'grade-desc'">↓</template>
                        </a>
                        <a
                          class="tag"
                          :class="{on: order.indexOf('cost') > -1}"
                          @click="handleOrderCost">
                          价格
                          <template v-if="order === 'cost-asc'">↑</template>
                          <template v-if="order === 'cost-desc'">↓</template>
                        </a>
                        <a
                          class="tag"
                          :class="{on: order.indexOf('publish-date') > -1}"
                          @click="handleOrderPublishDate">
                          出版日期
                          <template v-if="order === 'publish-date-asc'">↑</template>
                          <template v-if="order === 'publish-date-desc'">↓</template>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="selection">
            <div class="row columns is-multiline">
                <BookCard v-for="item in filteredAndOrderedList" :info="item" :key="item.id"></BookCard>
            </div>
        </div>
    </div>
</template>

<script>
    import BookCard from './BookCard'
    export default {
        mounted () {
            const booklist = this.$store.getters.bookList
            if (Array.isArray(booklist) && booklist.length === 0) {
              this.$store.dispatch('getBookList')
            }
        },
        components: {
          BookCard
        },
        computed: {
            bookList(){
                return this.$store.getters.bookList;
            },
            categories () {
                return this.$store.getters.categories;
            },
            nations () {
                return this.$store.getters.nations;
            },
            filteredAndOrderedList () {
                let list = [...this.bookList];
                // 按书名搜索
                if (this.certainBookName !== '') {
                  list = list.filter(item => item.bookname.includes(this.certainBookName))
                }

                // 按类型过滤
                if (this.filterCategory !== '') {
                    list = list.filter(item => item.category === this.filterCategory);
                }
                // 按国家过滤
                if (this.filterNation !== '') {
                    list = list.filter(item => item.nation === this.filterNation);
                }
                // 排序
                if (this.order !== '') {
                    // 按价格排序
                    if (this.order === 'cost-desc') {
                        list = list.sort((a, b) => b.price - a.price);
                    } else if (this.order === 'cost-asc') {
                        list = list.sort((a, b) => a.price - b.price);
                    }

                    // 按评分排序
                    else if (this.order === 'grade-desc') {
                        list = list.sort((a, b) => b.averageGrade - a.averageGrade)
                    } else if (this.order === 'grade-asc') {
                        list = list.sort((a, b) => a.averageGrade - b.averageGrade)
                    }

                    // 按出版日期排序
                    else if (this.order === 'publish-date-desc') {
                        list = list.sort((a, b) => b.publishDate - a.publishDate)
                    } else if (this.order === 'publish-date-asc') {
                        list = list.sort((a, b) => a.publishDate - b.publishDate)
                    }
                }
                return list;
            }
        },
        data () {
            return {
                filterCategory: '',
                filterNation: '',
                order: '',
                certainBookName: ''
            }
        },
        methods: {
            handleFilterCategory (category) {
                if (this.filterCategory === category) {
                    // 再次点击时，取消该过滤条件
                    this.filterCategory = '';
                } else {
                    this.filterCategory = category;
                }
            },
            handleFilterNation (nation) {
                if (this.filterNation === nation) {
                    this.filterNation = '';
                } else {
                    this.filterNation = nation;
                }
            },
            handleOrderDefault () {
                this.order = '';
            },
            handleOrderCost () {
                if (this.order === 'cost-desc') {
                    this.order = 'cost-asc';
                } else {
                    this.order = 'cost-desc';
                }
            },
            handleOrderGrade () {
                if (this.order === 'grade-desc') {
                    this.order = 'grade-asc'
                } else {
                    this.order = 'grade-desc'
                }
            },
            handleOrderPublishDate () {
              if (this.order === 'publish-date-desc') {
                this.order = 'publish-date-asc'
              } else {
                this.order = 'publish-date-desc'
              }
            }
        },
    }
</script>

<style scoped>
    .tag.on{
        background: #f2352e;
        border: 1px solid #f2352e;
        color: #fff;
    }
</style>
