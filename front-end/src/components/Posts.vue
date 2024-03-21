<template>
  <div>
    <h2>文章列表</h2>
    <ul>
      <li v-for="article in articles" :key="article.id">
        <router-link :to="{ name: 'article', params: { id: article.id }}">{{ article.title }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      articles: [
        { id: 1, title: '文章1', content: '這是第一篇文章的內容' },
        { id: 2, title: '文章2', content: '這是第二篇文章的內容' },
        { id: 3, title: '文章3', content: '這是第三篇文章的內容' }
      ]
    };
  }
};
</script>
