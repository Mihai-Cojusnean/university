<template>
    <div class="modal fade bd-example-modal-lg" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Edit person</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <input type="text" class="form-control" placeholder="Write your first name"
                                       v-model="firstName"/>
                            </div>
                            <div class="form-group col-md-6">
                                <input type="text" class="form-control" placeholder="Write your first name"
                                       v-model="lastName"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <input type="text" class="form-control"
                                       placeholder="Write your date of birth dd/mm/yyyy"
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
                                <input type="text" class="form-control" placeholder="Write your address"
                                       v-model="address"/>
                            </div>
                            <div class="form-group col-md-4">
                                <select class="form-control" v-model="country">
                                    <option value="none" disabled selected>{{ country }}</option>
                                    <option v-for="country in countries" :value="country">{{ country.name }}</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <select id="city" class="form-control" v-model="city">
                                    <option value="none" disabled selected>{{ city }}</option>
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
                                <input type="number" class="form-control" placeholder="Write your phone number"
                                       v-model="phone"/>
                            </div>
                        </div>
                        <div class="form-row align-items-end">
                            <div class="form-group col-md-10">
                                <select class="form-control" v-model="updatedBy">
                                    <option value="none" disabled selected>Updated by...</option>
                                    <option value="Cojusnean Mihai">Cojusnean Mihai</option>
                                    <option value="Kovalsky Liubomir">Kovalsky Liubomir</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" @click="update">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {getIndex} from "../logic/collection";

export default {
    props: ['people', 'personAttr', 'person'],
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
            addedBy: 'none',
            addedAt: '',
            updatedBy: 'none',
            countries: frontendData.countries
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
            this.addedBy = newValue.addedBy
            this.addedAt = newValue.addedAt
        }
    },
    // updated() {
    //     for (let i = 0; i < 3; i++) {
    //         if (this.country === this.countries[i].name) {
    //             this.country = this.countries[i];
    //             console.log(this.country)
    //             break;
    //         }
    //     }
    // },
    methods: {
        update: function () {
            fetch("/people/" + this.id, {
                method: "PUT",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify({
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
                    addedBy: this.addedBy,
                    addedAt: this.addedAt,
                    updatedBy: this.updatedBy
                })
            }).then(response => response.json().then(data => {
                this.people.splice(getIndex(this.people, data.id), 1, data);
            }));
        }
    }
}

</script>

<style>

</style>