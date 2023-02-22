import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex, axios)
// Create a new store instance.
export default new Vuex.Store({
    state: {
        peoples: [],
        people: null,
        user: null
    },
    mutations: {
        setPeople(state, peoples) {
            state.people = peoples
        },
        setUser(state, user) {
            state.user = user
        }
    },
    actions: {
        loadPeoples({commit}) {
            axios
                .get('http://localhost:8081/people/peoples')
                .then(data => {
                    commit('setPeople', data.data)
                })
        },
        loadUserById({commit}, id) {
            axios
                .get('http://localhost:8081/people/' + id)
                .then(data => {
                    commit('setUser', data.data)
                })
        }
    },
    getters: {
        peoples: s => s.peoples,
        people: s => s.people,
        getUser: s => s.user
    }
})