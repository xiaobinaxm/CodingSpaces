// 以下是自己书写的，与自动生成的效果一样，主要目的，为了熟悉代码
// 配置路由相关信息
import Vue from 'vue';
import VueRouter from 'vue-router';
// import Home from '../components/Home';
// import About from '../components/About';
// import User from '../components/User';

// 采用懒加载方式，动态使用组件
const Home = () => import('../components/Home');
const HomeMessage = () => import('../components/HomeMessage');
const HomeNews = () => import('../components/HomeNews');
const About = () => import('../components/About');
const User = () => import('../components/User');
const Profile = () => import('../components/Profile');


// 1.通过Vue.use（插件），安装插件
Vue.use(VueRouter);

// 2.创建Vuerouter对象
const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/user/:userId',
    component: User,
    meta: {
      title: '用户'
    }
  },
  {
    path: '/home',
    component: Home,
    meta: {
      title: '首页'
    },
    children: [
      {
        path: '',
        redirect: 'news'
      },
      {
        path: 'news',
        component: HomeNews
      },
      {
        path: 'message',
        component: HomeMessage
      }
    ]
  },
  {
    path: '/about',
    component: About,
    meta: {
      title: '关于'
    },
    //定义一个局部守卫
    beforeEnter: (to,from,next) => {
      console.log('about beforeEnter().....');
      next();
  },
  },
  {
    path: '/profile',
    component: Profile,
    meta: {
      title: "档案"
    }
  }
];

const router = new VueRouter({
  // 配置路由和组件之间的映射关系
  routes,
  // 关于模式的说法，
  //  history模式时：http://localhost:8080/home
  //  hash模式时：http://localhost:8080/#/home
  mode: 'history',
  linkActiveClass: 'active'
});


// hook 钩子  就是回调函数
// 导航守卫 不明白的话，看源码
// 前置钩子hook  guard
router.beforeEach((to,from,next) => {
  // document.title = to.meta.title;
  document.title = to.matched[0].meta.title;
  // console.log(to);
  // console.log('beforeEach.....');
  next();
});


// 后置钩子  hook
router.afterEach((to, from) => {
  // console.log('afterEach.....');
});


// 3.将router对象闯入到Vue实例中
export default router;





// 自动生成的
// import Vue from 'vue'
// import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
//
// Vue.use(Router)
//
// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'HelloWorld',
//       component: HelloWorld
//     }
//   ]
// })
