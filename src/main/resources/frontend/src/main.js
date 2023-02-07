import {createApp} from "vue";
import App from "@/App.vue";
import PeopleList from "@/components/PeopleList.vue";
import PeopleForm from "@/components/PeopleForm.vue";

const app = createApp(App)
    .component("PeopleList", PeopleList)
    .component("PeopleForm", PeopleForm)
    .component("PeopleRow", PeopleRow)

app.mount('#app');