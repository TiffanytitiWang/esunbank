<template>
  <div>
    <h2>登入</h2>
    <input type="text" v-model="username" placeholder="請輸入用戶名稱" />
    <input type="password" v-model="password" placeholder="請輸入密碼" />
    <button @click="login">登入</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    login() {
      this.$store.dispatch('login', { username: this.username, password: this.password })
          .then(() => {
            // 登入成功後，導航到帖子列表頁面或其他目標頁面
            this.$router.push('/articles');
          })
          .catch(() => {
            // 登入失敗，可以在這裡顯示錯誤信息
          });
    }
  }
};
</script>
