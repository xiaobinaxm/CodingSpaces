<template>
  <div>
    <ul>
      <li>消息1</li>
      <li>消息2</li>
      <li>消息3</li>
      <li>消息4</li>
    </ul>
  </div>

  <!--以下均可以使用Emmet语法-->
  <!--div#aoo>ul#uuulll>li.robin$${Robin$}*5-->
  <!--<div id="aoo">-->
    <!--<ul id="uuulll">-->
      <!--<li class="robin01">Robin1</li>-->
      <!--<li class="robin02">Robin2</li>-->
      <!--<li class="robin03">Robin3</li>-->
      <!--<li class="robin04">Robin4</li>-->
      <!--<li class="robin05">Robin5</li>-->
    <!--</ul>-->
  <!--</div>-->
  <!-- {}大括号代表的是文本指令 -->
  <!--div#box>p.title+ul.list>li.child$*3{我是第$个}^div#box2-->

  <!--div#box>p.title+ul.list>li.child$*3{我是第$个}*5^div#box2-->

  <!--div#box>p.title{我是第$个}*6+ul.list>li.child$$*5{我是第$个}-->
  <!--div>(ul>li>a)+div>p-->
  <!--div#aaa>(ul>li.name第$$个问题描述*6>button.title{按钮$}*4)+div>p#ddd$*3-->
  <!---->


</template>

<script>
    export default {
        name: "HomeMessage"
    }
</script>

<style scoped>

</style>
