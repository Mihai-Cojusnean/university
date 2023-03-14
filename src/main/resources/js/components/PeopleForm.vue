<template>
    <div>
        <validation-observer v-slot="{ invalid }">
            <form id="form" @submit.prevent="onSubmit">
                <div class="row mb-4">
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <input class="form-control"
                                   type="text"
                                   placeholder="Write your first name"
                                   v-model="firstName"
                                   name="firstName"/>
                        </validation-provider>
                    </div>
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <input class="form-control"
                                   type="text"
                                   placeholder="Write your first name"
                                   v-model="lastName"
                                   name="lastName"/>
                        </validation-provider>
                    </div>
                    <!--                    <div class="col-lg-2">-->
                    <!--                        <validation-provider v-slot="v" rules="required">-->
                    <!--                            <input class="form-check-input"-->
                    <!--                                   type="radio"-->
                    <!--                                   v-model="gender"-->
                    <!--                                   name="gender"-->
                    <!--                                   value="Male"/>-->
                    <!--                            <label class="form-check-label">Male</label>&ndash;&gt;-->
                    <!--                            <input class="form-check-input"-->
                    <!--                                   type="radio"-->
                    <!--                                   v-model="gender"-->
                    <!--                                   name="gender"-->
                    <!--                                   value="Female"/>-->
                    <!--                            <label class="form-check-label">Female</label>&ndash;&gt;-->
                    <!--                        </validation-provider>-->
                    <!--                    </div>-->
                    <div class="col-1">
                        female
                    </div>
                    <div class="col-2">
                        <input type="range"
                               name="gender"
                               min="0" max="100"
                               step="10"
                               v-model="gender">
                    </div>
                    <div class="col-1"> male
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <input class="form-control"
                                   placeholder="Your birthday" type="text" onfocus="(this.type='date')" id="date"
                                   v-model="dateOfBirth"
                                   name="dateOfBirth"/>
                        </validation-provider>
                    </div>
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <input class="form-control"
                                   type="text"
                                   placeholder="Write your address"
                                   v-model="address"
                                   name="address"/>
                        </validation-provider>
                    </div>
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <select class="form-select"
                                    v-model="country"
                                    name="country"
                                    @change="setCities($event)">
                                <option value="" disabled selected>Select the country you from</option>
                                <option v-for="country in countries" :value="country.name" :key="country.id">
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
                                <option value="" disabled selected>Select the city you from</option>
                                <option v-for="city in cities" :value="city.name" :key="city.id">
                                    {{ city.name }}
                                </option>
                            </select>
                        </validation-provider>
                    </div>
                </div>
                <div class="row mb-4">
                    <div class="col">
                        <validation-provider v-slot="v"  rules="required">
                            <input class="form-control"
                                   type="email"
                                   placeholder="Write your email example@mail.com"
                                   v-model="email"
                                   name="email"/>
                        </validation-provider>
                    </div>
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <input class="form-control"
                                   type="number"
                                   placeholder="Write your phone number"
                                   v-model="phone"
                                   name="phone"/>
                        </validation-provider>
                    </div>
                    <div class="col">
                        <validation-provider v-slot="v" rules="required">
                            <select class="form-select"
                                    v-model="addedBy"
                                    name="addedBy">
                                <option value="" disabled>Added by...</option>
                                <option v-for="author in authors" :value="author">{{ author }}</option>
                            </select>
                        </validation-provider>
                    </div>
                    <div class="col-2 d-grid gap-2">
                        <button type="submit" class="btn" :disabled="invalid">Save</button>
                    </div>
                </div>
            </form>
        </validation-observer>
    </div>
</template>

<script>
import {ValidationProvider} from "vee-validate";
import {ValidationObserver} from "vee-validate";

export default {
    props: ['countries', 'cities'],
    components: {
        ValidationObserver, ValidationProvider
    },
    data() {
        return {
            id: '',
            firstName: '',
            lastName: '',
            dateOfBirth: '',
            gender: '',
            email: '',
            address: '',
            country: '',
            city: '',
            phone: '',
            addedBy: '',
            authors: ['Cojușnean Mihai', 'Kovalsky Liubomir']
        }
    },
    methods: {
        onSubmit() {
            const form = document.querySelector('#form');
            const body = Object.fromEntries(new FormData(form));

            this.$store.dispatch('peopleStore/addPerson', body)

            this.id = this.firstName = this.lastName = this.dateOfBirth = this.gender =
                this.country = this.city = this.addedBy = this.email = this.address = this.phone = ''
        },
        setCities(event) {
            this.city = ''
            this.$store.dispatch('countriesStore/loadCities', event.target.selectedIndex)
        }
    }
}
</script>

<style>
.position-relative-example div {
    width: 2em;
    height: 2em;
    background-color: #ffffff;
    border-radius: .25rem;
}
</style>