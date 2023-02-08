import {createApp} from "vue";
import App from "./pages/App.vue";
import PeopleList from "./components/PeopleList.vue";
import PeopleForm from "./components/PeopleForm.vue";
import PeopleRow from "./components/PeopleRow.vue";

new Vue({
    el: '#app',
    render: a => a(App)
})

const app = createApp(App)
    .component("PeopleList", PeopleList)
    .component("PeopleForm", PeopleForm)
    .component("PeopleRow", PeopleRow)

app.mount('#app');