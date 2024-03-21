import Vue from 'vue';
import VueRouter from 'vue-router';
import ArticleList from '../components/ArticleList.vue';
import ArticleDetail from '../components/ArticleDetail.vue';

Vue.use(VueRouter);

const routes = [
    { path: '/', component: ArticleList },
    { path: '/article/:id', name: 'article', component: ArticleDetail }
];

const router = new VueRouter({
    routes
});

export default router;
