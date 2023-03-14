import Vue from 'vue'
import Vuex from "vuex";
import peopleStore from './modules/poepleStore'
import countriesStore from './modules/countriesStore'

Vue.use(Vuex)
export default new Vuex.Store({
    strict: true,
    modules: {
        peopleStore,
        countriesStore
    }
})