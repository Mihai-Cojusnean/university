<template>
    <div class="modal" tabindex="-1" id="myModal">
        <div class="modal-dialog modal-lg">
            <validation-observer v-slot="{ invalid }">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" style="color: #858585">Edit</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="form">
                            <div class="row mb-4">
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <input class="form-control"
                                               type="text"
                                               placeholder="Write your first name"
                                               v-model="person.firstName"
                                               name="firstName"/>
                                    </validation-provider>
                                </div>
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <input class="form-control"
                                               type="text"
                                               placeholder="Write your last name"
                                               v-model="person.lastName"
                                               name="lastName"/>
                                    </validation-provider>
                                </div>
                                <div class="col-1">
                                    female
                                </div>
                                <div class="col-2">
                                    <input type="range"
                                           name="gender"
                                           min="0" max="100"
                                           step="10"
                                           v-model="person.gender">
                                </div>
                                <div class="col-1"> male
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <input class="form-control"
                                               placeholder="Your birthday" type="text" onfocus="(this.type='date')"
                                               id="date"
                                               v-model="person.dateOfBirth"
                                               name="dateOfBirth"/>
                                    </validation-provider>
                                </div>
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <input class="form-control"
                                               type="text"
                                               placeholder="Write your address"
                                               v-model="person.address"
                                               name="address"/>
                                    </validation-provider>
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <select class="form-select"
                                                v-model="country"
                                                name="country"
                                                id="country"
                                                @change="setCities($event)">
                                            <option value="saved" disabled selected>{{ person.country }}</option>
                                            <option v-for="country in countries" :value="country.name">
                                                {{ country.name }}
                                            </option>
                                        </select>
                                    </validation-provider>
                                </div>
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <select class="form-select"
                                                v-model="city"
                                                name="city">
                                            <option value="saved" disabled selected>{{ person.city }}</option>
                                            <option value="" disabled>Select the city you from</option>
                                            <option v-for="city in cities" :value="city.name">{{ city.name }}</option>
                                        </select>
                                    </validation-provider>
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <input class="form-control"
                                               type="email"
                                               placeholder="Write your email example@mail.com"
                                               v-model="person.email"
                                               name="email"/>
                                    </validation-provider>
                                </div>
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <input class="form-control"
                                               type="number"
                                               placeholder="Write your phone number"
                                               v-model="person.phone"
                                               name="phone"/>
                                    </validation-provider>
                                </div>
                                <div class="col">
                                    <validation-provider v-slot="v" rules="required">
                                        <select class="form-select"
                                                v-model="updatedBy"
                                                name="updatedBy">
                                            <option value="" disabled selected>Updated by...</option>
                                            <option v-for="author in authors" :value="author">{{ author }}</option>
                                        </select>
                                    </validation-provider>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn" data-bs-dismiss="modal">Close</button>
                        <button type="submit"
                                class="btn"
                                data-bs-dismiss="modal"
                                :disabled="invalid"
                                @click="update">Save changes
                        </button>
                    </div>
                </div>
            </validation-observer>
        </div>
    </div>
</template>

<script>
import {ValidationProvider} from "vee-validate";
import {ValidationObserver} from "vee-validate";

export default {
    props: ['person', 'countries', 'cities'],
    components: {
        ValidationProvider, ValidationObserver
    },
    data() {
        return {
            id: '',
            country: 'saved',
            city: 'saved',
            updatedBy: '',
            authors: ['Cojușnean Mihai', 'Kovalsky Liubomir']
        }
    },
    methods: {
        update() {
            const body = Object.fromEntries($('form')
                .serializeArray()
                .map(pair => [pair.name, pair.value]));
            this.$store.dispatch('peopleStore/updatePerson', body)

            this.updatedBy = ''
        },
        setCities(event) {
            this.city = ''
            this.$store.dispatch('countriesStore/loadCities', event.target.selectedIndex)
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