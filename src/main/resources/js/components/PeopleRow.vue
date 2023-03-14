<template>
    <tbody style="color: #b0b0b0">
    <tr>
        <td>{{ person.firstName }}</td>
        <td>{{ person.lastName }}</td>
        <td>{{ person.gender }}</td>
        <td>{{ person.dateOfBirth }}</td>
        <td>{{ person.country }}</td>
        <td>{{ person.city }}</td>
        <td>{{ person.address }}</td>
        <td>{{ person.email }}</td>
        <td>{{ person.phone }}</td>
        <td><input type="button"
                   value="Edit"
                   data-bs-toggle="modal"
                   data-bs-target="#myModal"
                   @click="editPerson"></td>
        <td><input type="button"
                   value="X"
                   @click="deletePerson"></td>
    </tr>
    </tbody>
</template>

<script>
export default {
    props: ['person', 'countries'],
    methods: {
        editPerson() {
            const id = this.countries.find(country => country.name === this.person.country).id

            this.$store.dispatch('countriesStore/loadCities', id)

            this.$store.commit('peopleStore/setPerson', this.person)
        },
        deletePerson() {
            this.$store.dispatch('peopleStore/deletePerson', this.person.id)
        }
    }
}
</script>

<style>
</style>