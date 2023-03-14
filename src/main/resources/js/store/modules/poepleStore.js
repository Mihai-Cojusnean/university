import axios from "axios";

const peopleStore = {
    namespaced: true,
    state: {
        people: [],
        person: ''
    },
    mutations: {
        setPeople(state, people) {
            state.people = people
        },
        addPerson(state, person) {
            state.people.push(person)
        },
        setPerson(state, person) {
            state.person = person
        },
        updatePerson(state, updatedPerson) {
            const person = state.people.find(person => person.id === updatedPerson.id)
            state.people.splice(state.people.indexOf(person), 1)
            state.people.push(person)
        },
        deletePerson(state, id) {
            const person = state.people.find(person => person.id === id)
            state.people.splice(state.people.indexOf(person), 1)
        }
    },
    actions: {
        loadPeople({commit}) {
            axios
                .get('people')
                .then(response => commit('setPeople', response.data))
        },
        addPerson({commit}, body) {
            axios
                .post("people", body, {headers: {"Content-Type": "application/json"}})
                .then(response => commit('addPerson', response.data));
        },
        deletePerson({commit}, id) {
            axios
                .delete('people/' + id)
                .then(() => commit('deletePerson', id))
        },
        updatePerson({commit}, body) {
            const id = peopleStore.state.person.id;
            body['id'] = id
            axios
                .put('people/' + id, body, {headers: {"Content-Type": "application/json"}})
                .then(response => {
                    commit('updatePerson', response.data)
                })
        }
    },
    getters: {
        people: s => s.people,
        person: s => s.person
    }
}

export default peopleStore;