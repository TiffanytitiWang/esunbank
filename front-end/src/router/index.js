import Vue from 'vue';
import VueRouter from 'vue-router';
import Register from '../components/Register.vue';
import Login from '../components/Login.vue';
import PostList from '../components/PostList.vue';
import PostDetail from '../components/PostDetail.vue';
import CreatePost from '../components/CreatePost.vue';
import EditPost from '../components/EditPost.vue';

Vue.use(VueRouter);

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/register', component: Register },
  { path: '/login', component: Login },
  { path: '/Posts', component: PostList },
  { path: '/Post/:id', component: PostDetail },
  { path: '/Post/create', component: CreatePost },
  { path: '/Post/edit/:id', component: EditPost }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
