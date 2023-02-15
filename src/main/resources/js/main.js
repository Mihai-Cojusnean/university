import App from "./pages/App.vue";
import Vue from "vue";
import PeopleList from "./components/PeopleList.vue";
import PeopleRow from "./components/PeopleRow.vue";
import peopleForm from "./components/PeopleForm.vue";

new Vue({
    el: '#app',
    components: {
        'PeopleList': PeopleList,
        'PeopleRow': PeopleRow,
        'PeopleForm': peopleForm
    },
    render: a => a(App)
})