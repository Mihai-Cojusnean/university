<template>
        <h1 class="green"> Add new person </h1>
        <peopleList :people="people"></peopleList>
</template>

<script>
import PeopleList from "@/components/PeopleList.vue";

export default {
    components: {
        PeopleList
    },
    data() {
        return {
            people: []
        }
    }
}
</script>

<style scoped>
h1 {
    font-weight: 500;
    font-size: 2.6rem;
    top: -10px;
}

.greetings h1 {
    text-align: center;
}

@media (min-width: 1024px) {
    .greetings h1 {
        text-align: left;
    }
}
header {
    line-height: 1.5;
}

@media (min-width: 1024px) {
    header {
        display: flex;
        place-items: center;
        padding-right: calc(var(--section-gap) / 2);
    }

    header {
        display: flex;
        place-items: flex-start;
        flex-wrap: wrap;
    }
}
</style>
