import App from "./pages/App.vue";
import Vue from "vue";

import "./assets/base.css";
import './assets/main.css'

new Vue({
    el: '#app',
    render: a => a(App)
})