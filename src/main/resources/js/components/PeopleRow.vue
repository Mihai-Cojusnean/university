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
        <td>{{ person.addedBy }}</td>
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
            const country = this.countries.find(country => country.name === this.person.country)

            this.$store.commit('countriesStore/setCountry', this.person.country)
            this.$store.commit('countriesStore/setCities', country.cities)
            this.$store.commit('peopleStore/setPerson', this.person)
        },
        deletePerson() {
            this.$store.dispatch('peopleStore/deletePerson', this.person.id)
        }
    }
}
</script>

<style>
i {
    display: flex;
    place-items: center;
    place-content: center;
    width: 32px;
    height: 32px;

    color: var(--color-text);
}

h3 {
    font-size: 1.2rem;
    font-weight: 500;
    margin-bottom: 0.4rem;
    color: var(--color-heading);
}

@media (min-width: 1024px) {
    i {
        top: calc(50% - 25px);
        left: -26px;
        position: absolute;
        border: 1px solid var(--color-border);
        background: var(--color-background);
        border-radius: 8px;
        width: 50px;
        height: 50px;
    }
}
</style>