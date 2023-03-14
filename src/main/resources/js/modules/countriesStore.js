import axios from "axios";

const countriesStore = {
    namespaced: true,
    state: {
        countries: [],
        cities: [],
        country: '',
    },
    mutations: {
        setCountries(state, countries) {
            state.countries = countries
        },
        setCountry(state, country) {
          state.country = country
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