<template>
    <div class="modal" tabindex="-1" id="myModal">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" style="color: #858585">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="form">
                        <div class="row mb-4">
                            <div class="col">
                                <input class="form-control"
                                       type="text"
                                       placeholder="Write your first name"
                                       v-model="person.firstName"
                                       name="firstName"/>
                            </div>
                            <div class="col">
                                <input class="form-control"
                                       type="text"
                                       placeholder="Write your last name"
                                       v-model="person.lastName"
                                       name="lastName"/>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col">
                                <input class="form-control"
                                       type="text"
                                       placeholder="Write your date of birth dd/mm/yyyy"
                                       v-model="person.dateOfBirth"
                                       name="dateOfBirth"/>
                            </div>
                            <div class="col">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input"
                                           type="radio"
                                           value="Male"
                                           v-model="person.gender"
                                           name="gander"/>
                                    <label class="form-check-label">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input"
                                           type="radio"
                                           value="Female"
                                           v-model="person.gender"
                                           name="gender">
                                    <label class="form-check-label">Female</label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col">
                                <input class="form-control"
                                       type="text"
                                       placeholder="Write your address"
                                       v-model="person.address"
                                       name="address"/>
                            </div>
                            <div class="form-group col-md-4">
                                <select class="form-select"
                                        v-model="country"
                                        name="country"
                                        @change="setCities"
                                        id="country">
                                    <option value="none" disabled selected>{{ person.country }}</option>
                                    <option v-for="country in countries" :value="country">{{ country.name }}</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <select class="form-select"
                                        v-model="city"
                                        name="city">
                                    <option value="saved" disabled selected>{{ person.city }}</option>
                                    <option value="none">Select the city you from</option>
                                    <option v-for="city in cities" :value="city.name">{{ city.name }}</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col">
                                <input class="form-control"
                                       type="email"
                                       placeholder="Write your email example@mail.com"
                                       v-model="person.email"
                                       name="email"/>
                            </div>
                            <div class="form-group col-md-6">
                                <input class="form-control"
                                       type="number"
                                       placeholder="Write your phone number"
                                       v-model="person.phone"
                                       name="phone"/>
                            </div>
                        </div>
                        <div class="row mb-4 align-items-end">
                            <div class="col">
                                <select class="form-select"
                                        v-model="updatedBy"
                                        name="updatedBy">
                                    <option value="none" disabled selected>Updated by...</option>
                                    <option value="Cojusnean Mihai">Cojusnean Mihai</option>
                                    <option value="Kovalsky Liubomir">Kovalsky Liubomir</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" @click="update" data-dismiss="modal">Save changes
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ['person', 'countries'],
    data: function () {
        return {
            id: '',
            country: 'none',
            city: 'saved',
            updatedBy: 'none'
        }
    },
    computed: {
        cities() {
            return this.$store.getters["countriesStore/cities"]
        }
    },
    methods: {
        update() {
            const body = Object.fromEntries($('form')
                .serializeArray()
                .map(pair => [pair.name, pair.value]));
            body['country'] = this.country.name
            this.$store.dispatch('peopleStore/updatePerson', body)
        },
        setCities() {
            this.city = "none"
            const country = this.countries.find(country => country.name === this.country.name)
            this.$store.commit('countriesStore/setCities', country.cities)
        }
    }
}

</script>

<style>

.modal-content {
    background-color: #282828FF;
    font-family: Inter, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu,
    Cantarell, 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif;
    font-size: 15px;
    text-rendering: optimizeLegibility;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}
</style>