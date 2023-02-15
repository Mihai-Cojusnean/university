<script setup>
import { RouterLink, RouterView } from 'vue-router'
import PeopleForm from './components/PeopleForm.vue'
import PeopleList from './components/PeopleList.vue'
</script>

<template>
  <header>

    <PeopleForm/>
    <PeopleList/>


<!--    <div class="wrapper">-->
<!--      <HelloWorld msg="You did it!" />-->

<!--      <nav>-->
<!--        <RouterLink to="/">Home</RouterLink>-->
<!--        <RouterLink to="/about">About</RouterLink>-->
<!--      </nav>-->
<!--    </div>-->
  </header>

<!--  <RouterView />-->
</template>

<style scoped>

</style>
