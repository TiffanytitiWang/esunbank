import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        articles: [
            { id: 1, title: '文章1', content: '這是第一篇文章的內容' },
            { id: 2, title: '文章2', content: '這是第二篇文章的內容' },
            { id: 3, title: '文章3', content: '這是第三篇文章的內容' }
        ]
    },
    mutations: {},
    actions: {},
    modules: {}
});
