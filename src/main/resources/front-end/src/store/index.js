import { createStore } from 'vuex'

export default createStore({
    state: {
        firstName: 'John',
        lastName: 'Doe'
    },
    mutations: {
        setPeoples(state, peoples) {
            state.users = peoples
        },
    },
    actions: {
        async fetch({commit}) {
            await this.axios.get('/people')
                .then(response => {
                    commit('setPeoples', response)
                })
        },
    },
    getters: {
        peoples: s => s.peoples,
        people: s => s.people
    }
})