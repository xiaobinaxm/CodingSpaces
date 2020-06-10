import Vue from 'vue'
import Router from 'vue-router'

// 懒加载方式
const Home = () => import('../views/home/Home');
const Category = () => import('../views/category/Category');
const Cart = () => import('../views/cart/Cart');
const Profile = () => import('../views/profile/Profile');


Vue.use(Router);


const routes = [
  {
    path: '',
    redirect: Home
  },
  {
    path: '/',
    redirect: Home
  },
  {
    path: '/home',
    component: Home
  },
  {
    path: '/category',
    component: Category
  },
  {
    path: '/cart',
    component: Cart
  },
  {
    path: '/profile',
    component: Profile
  }
];

const router = new Router({
  routes,
  //采用history模式，默认的hash模式，url中会有一个#号，个人认为难看
  mode: 'history'
});

export default router;



// 自动生成的，不便于理解，我们自己写，分开
// export default new Router({
//   routes: [
//     {
//       path: '/',
//       name: 'HelloWorld',
//     }
//   ]
// })
