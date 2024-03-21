const state = {
  posts: [] // 文章列表
};

const mutations = {
  addArticle(state, post) {
    state.posts.push(post);
  },
  editArticle(state, { id, updatedPost }) {
    const index = state.posts.findIndex(post => post.id === id);
    if (index !== -1) {
      state.posts.splice(index, 1, updatedPost);
    }
  },
  deleteArticle(state, id) {
    state.posts = state.posts.filter(post => post.id !== id);
  }
};

const actions = {
  addPost({ commit }, article) {
    // 實作新增文章邏輯，比如發送請求將文章保存到後端
    commit('addPost', article);
  },
  editPost({ commit }, { id, updatedPost }) {
    // 實作編輯文章邏輯，比如發送請求將更新後的文章保存到後端
    commit('editPost', { id, updatedPost });
  },
  deletePost({ commit }, id) {
    // 實作刪除文章邏輯，比如發送請求將文章從後端刪除
    commit('deletePost', id);
  }
};

export default {
  state,
  mutations,
  actions
};
