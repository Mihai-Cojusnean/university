import App from "./pages/App.vue";
import Vue from "vue";
import store from './store/people'

import "./assets/base.css";
import './assets/main.css'

new Vue({
    el: '#app',
    store,
    render: a => a(App)
})