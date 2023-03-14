import axios from "axios";

const countriesStore = {
    namespaced: true,
    state: {
        countries: [],
        cities: [],
    },
    mutations: {
        setCountries(state, countries) {
            state.countries = countries
        },
        setCities(state, cities) {
            state.cities = cities
        }
    },
    actions: {
        loadCountries({commit}) {
            axios
                .get('countries')
                .then(response => commit('setCountries', response.data))
        },
        loadCities({commit}, id) {
            axios
                .get('countries/' + id)
                .then(response => commit('setCities', response.data))
        }
    },
    getters: {
        countries(state) {
            console.log('getters is called')
            return state.countries
        },
        cities: s => s.cities
    }
}

export default countriesStore;