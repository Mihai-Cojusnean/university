<template>
    <h1>Hello from peoplelist</h1>
    <div style="position: relative; width: 800px">
        <PeopleForm :people="people" :personAttr="person"/>
        <table class="table table-bordered table-hover">'
            <thead style="background-color: #858585; color: #152223">
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Gender</th>
                <th>Date of birth</th>
                <th>Country</th>
                <th>City</th>
                <th>Address</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Form</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <PeopleRow v-for="person in people" :key="person.id" :person="person"
                       :editMethod="editMethod" :people="people"/>
        </table>
    </div>
</template>

<script>
import PeopleForm from "../../../templates/components/PeopleForm.vue";
import PeopleRow from "../../../templates/components/PeopleRow.vue";

export default {
    components: PeopleForm, PeopleRow,
    props: ['people'],
    data: function () {
        return {
            person: null
        }
    },
    created: function () {
        fetch("/people").then(result => result.json()
            .then(data => data.forEach(person => this.people.push(person))))
    },
    methods: {
        editMethod: function (person) {
            this.person = person;
        }
    }
}
</script>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}
</style>
