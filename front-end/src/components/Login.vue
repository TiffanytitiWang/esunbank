<template>
  <div>
    <h2>註冊</h2>
    <form @submit.prevent="register">
      <div>
        <label for="username">用戶名稱：</label>
        <input type="text" id="username" v-model="username" required>
      </div>
      <div>
        <label for="password">密碼：</label>
        <input type="password" id="password" v-model="password" required>
      </div>
      <div>
        <button type="submit">註冊</button>
      </div>
    </form>

    <h2>登入</h2>
    <form @submit.prevent="login">
      <div>
        <label for="loginUsername">用戶名稱：</label>
        <input type="text" id="loginUsername" v-model="loginUsername" required>
      </div>
      <div>
        <label for="loginPassword">密碼：</label>
        <input type="password" id="loginPassword" v-model="loginPassword" required>
      </div>
      <div>
        <button type="submit">登入</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      username: '',
      password: '',
      loginUsername: '',
      loginPassword: ''
    };
  },
  methods: {
    register() {
      axios.post('http://localhost:8081/api/register', {
        username: this.username,
        password: this.password
      })
        .then(response => {
          // 在這裡處理註冊成功後的操作，例如顯示成功消息或重定向到登入頁面
          console.log('註冊成功:', response.data);
        })
        .catch(error => {
          // 在這裡處理錯誤，例如顯示錯誤消息
          console.error('註冊失敗:', error);
        });
    },
    login() {
      axios.post('http://localhost:8081/api/login', {
        phone:  this.loginUsername,
        password: this.loginPassword
      })
        .then(response => {
          // 在這裡處理登入成功後的操作，例如將用戶信息保存到本地存儲，然後導航到應用的主頁面
          console.log('登入成功:', response.data);
        })
        .catch(error => {
          // 在這裡處理錯誤，例如顯示錯誤消息
          console.error('登入失敗:', error);
        });
    }
  }
};
</script>
