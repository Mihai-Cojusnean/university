<template>
    <div class="container" style="padding-top: 50px">
        <people-form :people="people"/>
        <table class="table table-bordered table-hover" id="myTable">
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
                <th>Added by</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <people-row v-for="person in people"
                        :key="person.id"
                        :person="person"
                        :editMethod="editMethod"
                        :people="people"/>
        </table>
        <editPeopleModel :personAttr="person"
                         :people="people"/>
    </div>
</template>

<script>
import PeopleForm from "./PeopleForm.vue";
import PeopleRow from "./PeopleRow.vue";
import EditPeopleModel from "./EditPeopleModel.vue"

export default {
    props: ['people'],
    components: {
        PeopleForm,
        PeopleRow,
        EditPeopleModel
    },
    data: function () {
        return {
            person: null
        }
    },
    methods: {
        editMethod: function (person) {
            this.person = person;
        }
    }
}
</script>

<style>
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
    background-color: darkslategrey;
}

body {
    height: 100%
}

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

h5 {
    color: #181818;
}

@media (min-width: 1024px) {
    .greetings h1,
    .greetings h3 {
        text-align: left;
    }
}
</style>