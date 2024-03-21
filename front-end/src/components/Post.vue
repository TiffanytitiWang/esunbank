<template>
  <div>
    <h2>{{ article.title }}</h2>
    <p>{{ article.content }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      article: null
    };
  },
  created() {
    const id = this.$route.params.id;
    this.article = this.articles.find(article => article.id == id);
  },
  computed: {
    articles() {
      return this.$store.state.articles;
    }
  }
};
</script>
