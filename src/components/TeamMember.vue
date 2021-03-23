<template>
  <div>
    <h1>{{ MemberName }}</h1>
  </div>
</template>

<script>
export default {
  name: "TeamMember",
  computed: {
    MemberName() {
      return this.$route.params.membername
    }
  }
}
</script>

<style scoped>

</style>
