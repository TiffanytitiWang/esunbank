<template>
  <div>
    <h2>{{ post.title }}</h2>
    <p>{{ post.content }}</p>

    <!-- 顯示留言列表 -->
    <ul>
      <li v-for="comment in post.comments" :key="comment.id">{{ comment.text }}</li>
    </ul>

    <!-- 留言輸入框 -->
    <textarea v-model="newComment" placeholder="請輸入留言"></textarea>
    <button @click="addComment">提交留言</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newComment: ''
    };
  },
  computed: {
    post() {
      // 假設使用路由的參數來獲取文章 ID
      const postId = this.$route.params.id;
      // 從 store 中獲取相應的文章信息
      return this.$store.state.posts.find(post => post.id === postId);
    }
  },
  methods: {
    addComment() {
      // 在這裡處理添加留言的邏輯，比如將留言提交到後端保存
      const newComment = {
        id: Date.now(), // 假設使用時間戳作為留言 ID
        text: this.newComment
      };
      this.post.comments.push(newComment);
      // 清空輸入框
      this.newComment = '';
    }
  }
};
</script>
