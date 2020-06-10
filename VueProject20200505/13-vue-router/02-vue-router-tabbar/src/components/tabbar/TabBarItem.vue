<template>

  <div class="tab-bar-item" @click="itemClick">
    <!--slot插槽是要被替换掉的，所有不要对slot设置属性-->
    <div v-if="!isActive">
     <slot name="item-icon"></slot>
    </div>
    <div v-else>
     <slot name="item-icon-active"></slot>
    </div>
    <!--<div :class="{active: isActive}">-->
    <div :style="activeStyle">
      <slot name="item-text"></slot>
    </div>
  </div>

  <!--
  <div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/home.png" alt="">
      <div>首页</div>
    </div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/categories.png" alt="">
      <div>分类</div>
    </div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/shopcart.png" alt="">
      <div>购物车</div>
    </div>
    <div class="tab-bar-item">
      <img src="../../assets/img/tabbar/profile.png" alt="">
      <div>我的</div>
    </div>
  </div>
-->
</template>

<script>
    export default {
      name: "TabBarItem",
      props: {
        path: String,
        activeColor: {
          type: String,
          default: 'red'
        }
      },
      data(){
        return{
          //此处是写死的，不能这么写
          // isActive: false
        }
      },
      computed: {
        isActive(){
          // 动态设置属性值
          return this.$route.path.indexOf(this.path) !== -1;
        },
        activeStyle(){
          return this.isActive ? {color: this.activeColor} : {};
        }
      },
      methods: {
        itemClick(){
          console.log('itemClick....');
          //this.$router.push(this.path);//双击或者连续点击或报错，采用下面这种方式
          //方法一：
          // if(this.$route.path === this.path) return;
          // this.$router.push(this.path);
          //方法二：
          this.$router.push(this.path).catch(err => err);
        }
      }
    }
</script>

<style scoped>
  .tab-bar-item{
    flex: 1;
    text-align: center;
    height: 49px;
    font-size: 14px;
  }

  .tab-bar-item img{
    width: 24px;
    height: 24px;
    margin-top: 3px;
    vertical-align: middle;
    margin-bottom: 2px;
  }

/*  不能写死，此处不能使用
  .active{
    color: red;
  }*/
</style>
