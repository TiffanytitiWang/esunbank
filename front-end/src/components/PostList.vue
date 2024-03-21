<template>
  <div>
    <h2>文章列表</h2>
    <ul>
      <li v-for="post in posts" :key="post.id">
        <router-link :to="{ name: 'post', params: { id: post.id }}">{{ post.title }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      posts: [
        { id: 1, title: '文章1', content: '這是第一篇文章的內容' },
        { id: 2, title: '文章2', content: '這是第二篇文章的內容' },
        { id: 3, title: '文章3', content: '這是第三篇文章的內容' }
      ]
    };
  }
};
</script>
