<template>
    <div>
        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control" placeholder="Write your first name" v-model="firstName"/>
                </div>
                <div class="form-group col-md-6">
                    <input type="text" class="form-control" placeholder="Write your first name" v-model="lastName"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="text" class="form-control" placeholder="Write your date of birth dd/mm/yyyy"
                           v-model="dateOfBirth"/>
                </div>
                <div class="form-group col-md-6">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions"
                               value="Male" v-model="gender">
                        <label class="form-check-label">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions"
                               value="Female" v-model="gender">
                        <label class="form-check-label">Female</label>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <input type="text" class="form-control" placeholder="Write your address" v-model="address"/>
                </div>
                <div class="form-group col-md-4">
                    <select class="form-control" v-model="country">
                        <option value="none" disabled selected>Select the country you from</option>
                        <option v-for="country in countries" :value="country">{{ country.name }}</option>
                    </select>
                </div>
                <div class="form-group col-md-4">
                    <select id="city" class="form-control" v-model="city">
                        <option value="none" disabled selected>Select the city you from</option>
                        <option v-for="city in country.cities" :value="city">{{ city.name }}</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <input type="email" class="form-control" placeholder="Write your email example@mail.com"
                           v-model="email"/>
                </div>
                <div class="form-group col-md-6">
                    <input type="number" class="form-control" placeholder="Write your phone number" v-model="phone"/>
                </div>
            </div>
            <div class="form-row align-items-end">
                <div class="form-group col-md-10">
                    <input type="text" class="form-control" placeholder="" v-model="form"/>
                </div>
                <div class="form-group col-md-2 bottom-0">
                    <button type="button" class="btn btn-lg btn-block" @click="create">Save</button>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
import {getIndex} from "../logic/collection";
import list_of_countries from '../logic/collection.js'

export default {
    props: ['people', 'personAttr'],
    data: function () {
        return {
            id: '',
            firstName: '',
            lastName: '',
            dateOfBirth: '',
            gender: '',
            email: '',
            address: '',
            country: 'none',
            city: 'none',
            phone: '',
            form: '',
            countries: list_of_countries
        }
    },
    watch: {
        personAttr: function (newValue) {
            this.id = newValue.id
            this.firstName = newValue.firstName
            this.lastName = newValue.lastName
            this.dateOfBirth = newValue.dateOfBirth
            this.gender = newValue.gender
            this.email = newValue.email
            this.address = newValue.address
            this.country = newValue.country
            this.city = newValue.city
            this.phone = newValue.phone
            this.form = newValue.form
        }
    },
    methods: {
        create: function () {
            let body = JSON.stringify({
                id: this.id,
                firstName: this.firstName,
                lastName: this.lastName,
                dateOfBirth: this.dateOfBirth,
                gender: this.gender,
                email: this.email,
                address: this.address,
                country: this.country.name,
                city: this.city.name,
                phone: this.phone,
                form: this.form
            })
            if (this.id) {
                fetch("/people/" + this.id, {
                    method: "PUT",
                    headers: {"Content-Type": "application/json"},
                    body: body
                }).then(response => response.json().then(data => {
                    this.people.splice(getIndex(this.people, data.id), 1, data);
                }));
            } else {
                fetch("/people/", {
                    method: "POST",
                    headers: {"Content-Type": "application/json"},
                    body: body
                }).then(response => response.json().then(data => {
                    this.people.push(data);
                }));
            }
            this.id = this.firstName = this.lastName = this.dateOfBirth = this.gender
                = this.email = this.address = this.phone = this.form = ''
            this.country = this.city = 'none'
        }
    }
}
</script>

<style>
.btn, .btn:hover, .btn:active, .btn:visited {
    background-color: #858585;
}

.btn:hover {
    background-color: darkslategrey;
}

.position-relative-example {
    height: 200px;
    width: 100%;
    background-color: #f5f5f5;
}

.position-relative-example div {
    width: 2em;
    height: 2em;
    background-color: #343a40;
    border-radius: .25rem;
}
</style>