<template>
    <div class="product-display">
        <div class="list-control">
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
                    <span class="tag is-white">Order：</span>
                    <a
                            class="tag"
                            :class="{on: order === ''}"
                            @click="handleOrderDefault">Default</a>
                    <a
                            class="tag"
                            :class="{on: order.indexOf('cost') > -1}"
                            @click="handleOrderCost">
                        Price
                        <template v-if="order === 'cost-asc'">↑</template>
                        <template v-if="order === 'cost-desc'">↓</template>
                    </a>
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
            this.$store.dispatch('getBookList');
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
                    if (this.order === 'cost-desc') {
                        list = list.sort((a, b) => b.price - a.price);
                    } else if (this.order === 'cost-asc') {
                        list = list.sort((a, b) => a.price - b.price);
                    }
                }
                return list;
            }
        },
        data () {
            return {
                filterCategory: '',
                filterNation: '',
                order: ''
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
