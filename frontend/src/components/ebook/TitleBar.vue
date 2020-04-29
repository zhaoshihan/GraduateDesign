<template>
  <transition name="slide-down">
      <div class="title-wrapper" v-show="ifTitleAndMenuShow">
        <div class="left">
          <span class="icon-back ebook-icon" @click="backHome"></span>
        </div>
        <div class="right">
          <div class="icon-wrapper">
            <span class="icon-cart ebook-icon"></span>
          </div>
          <div class="icon-wrapper">
            <span class="icon-person ebook-icon"></span>
          </div>
          <div class="icon-wrapper">
            <span class="icon-more ebook-icon"></span>
          </div>
        </div>
      </div>
    </transition>
</template>

<script>
export default {
  props: {
    ifTitleAndMenuShow: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    backHome () {
      this.$router.push('/home')
    }
  }
}

</script>

<style lang='scss' scoped>
@import '../../assets/styles/global';
.title-wrapper {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 101;
    display: flex;
    width: 100%;
    height: 8%;
    background: white;
    box-shadow: 0 px2rem(8) px2rem(8) rgba(0, 0, 0, .15);
    .left {
      flex: 0 0 10%;
      @include center;
      .icon-back {
        font-size: 1.75em;
      }
    }
    .right {
      flex: 1;
      display: flex;
      justify-content: flex-end;
      .icon-wrapper {
        flex: 0 0 5%;
        @include center;
        .icon-cart {
          font-size: 2em;
        }
        .icon-person {
          font-size: 2em;
        }
        .icon-more {
          font-size: 2em;
        }
      }
    }
  }
</style>
