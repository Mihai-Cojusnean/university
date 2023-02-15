//
// export const state = () => ({
//     peoples: [],
//     people: null
// })
//
// export const actions = {
//     async fetch({commit}) {
//         await this.axios.get('/people')
//             .then(response => {
//                 commit('setPeoples', response)
//             })
//     },
// }
//
// export const mutations = {
//     setPeoples(state, peoples) {
//         state.users = peoples
//     },
// }
//
// export const getters = {
//     peoples: s => s.peoples,
//     people: s => s.people
// }