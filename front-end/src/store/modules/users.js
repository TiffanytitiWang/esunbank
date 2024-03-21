const state = {
  currentUser: null,
  isLoggedIn: false
};

const mutations = {
  setUser(state, user) {
    state.currentUser = user;
    state.isLoggedIn = true;
  },
  logout(state) {
    state.currentUser = null;
    state.isLoggedIn = false;
  }
};

const actions = {
  login({ commit }, user) {
    // 在這裡實作登入邏輯，比如發送請求驗證用戶名稱和密碼
    // 登入成功後，將用戶信息存入狀態中
    commit('setUser', user);
  },
  logout({ commit }) {
    // 實作登出邏輯，清除用戶信息
    commit('logout');
  }
};

export default {
  state,
  mutations,
  actions
};
