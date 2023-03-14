<template>
    <div class="container text-center justify-content-md-center" style="padding-top: 50px">
        <nav class="d-flex align-items-start">
            <div class="nav nav-tabs" id="nav-tab" role="tablist">
                <button class="nav-link active"
                        id="nav-home-tab"
                        data-bs-toggle="tab"
                        data-bs-target="#nav-home"
                        type="button"
                        role="tab"
                        aria-controls="nav-home"
                        aria-selected="true">Add person
                </button>
                <button class="nav-link"
                        id="nav-profile-tab"
                        data-bs-toggle="tab"
                        data-bs-target="#nav-profile"
                        type="button"
                        role="tab"
                        aria-controls="nav-profile"
                        aria-selected="false">People table
                </button>
            </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active"
                 id="nav-home"
                 role="tabpanel"
                 aria-labelledby="nav-home-tab"
                 tabindex="0">
                <people-form :countries="countries"
                             :cities="cities"
                             style="padding-bottom: 30px"/>
                <table class="table table-bordered table-hover" id="myTable">
                    <thead style="background-color: #858585;">
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
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <people-row v-for="person in people"
                                :key="person.id"
                                :person="person"
                                :countries="countries"/>
                </table>
                <editPeopleModel :person="person"
                                 :countries="countries"
                                 :cities="cities"/>
            </div>
            <div class="tab-pane fade"
                 id="nav-profile"
                 role="tabpanel"
                 aria-labelledby="nav-profile-tab"
                 tabindex="1">
            </div>
        </div>
    </div>
</template>

<script>
import PeopleForm from "./PeopleForm.vue";
import PeopleRow from "./PeopleRow.vue";
import EditPeopleModel from "./EditPeopleModel.vue"

export default {
    computed: {
        countries() {
            return this.$store.getters['countriesStore/countries']
        },
        cities() {
            return this.$store.getters['countriesStore/cities']
        },
        people() {
            return this.$store.getters['peopleStore/people']
        },
        person() {
            return this.$store.getters['peopleStore/person']
        }
    },
    created() {
        this.$store.dispatch('peopleStore/loadPeople')
        this.$store.dispatch('countriesStore/loadCountries')
    },
    components: {
        PeopleForm,
        PeopleRow,
        EditPeopleModel
    }
}
</script>

<style>
.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
    background-color: darkslategrey;
}

.nav-link {
    color: darkslategrey;
}

.nav-link:hover {
    color: #b0b0b0;
}

body {
    height: 100%
}

table {
    padding-top: 10px;
}
</style>