<template>
    <div>
        <form id="form">
            <div class="row mb-4">
                <div class="col">
                    <validation-provider v-slot="v" rules="required">
                        <input class="form-control"
                               type="text"
                               placeholder="Write your first name"
                               v-model="firstName"
                               name="firstName"/>
                        <span>{{ v.errors[0] }}</span>
                    </validation-provider>
                </div>
                <div class="col">
                    <validation-provider v-slot="{ errors }" rules="required">
                        <input class="form-control"
                               type="text"
                               placeholder="Write your first name"
                               v-model="lastName"
                               name="lastName"/>
                        <span>{{ errors[0] }}</span>
                    </validation-provider>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col">
                    <input class="form-control"
                           type="text"
                           placeholder="Write your date of birth dd/mm/yyyy"
                           v-model="dateOfBirth"
                           name="dateOfBirth"/>
                </div>
                <div class="col">
                    <validation-provider v-slot="v" rules="required">
                        <input class="form-check-input"
                               type="radio"
                               v-model="gender"
                               name="gender"
                               value="Male"/>
                        <label class="form-check-label">Male</label>
                        <input class="form-check-input"
                               type="radio"
                               v-model="gender"
                               name="gender"
                               value="Female"/>
                        <label class="form-check-label">Female</label>
                    </validation-provider>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col">
                    <input class="form-control"
                           type="text"
                           placeholder="Write your address"
                           v-model="address"
                           name="address"/>
                </div>
                <div class="col">
                    <select class="form-select"
                            v-model="country"
                            name="country"
                            @change="setCities">
                        <option value="none" disabled selected>Select the country you from</option>
                        <option v-for="country in countries" :value="country">{{ country.name }}</option>
                    </select>
                </div>
                <div class="col">
                    <select class="form-select"
                            v-model="city"
                            name="city">
                        <option value="none" disabled selected>Select the city you from</option>
                        <option v-for="city in country.cities" :value="city.name">{{ city.name }}</option>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col">
                    <input class="form-control"
                           type="email"
                           placeholder="Write your email example@mail.com"
                           v-model="email"
                           name="email"/>
                </div>
                <div class="col">
                    <input class="form-control"
                           type="number"
                           placeholder="Write your phone number"
                           v-model="phone"
                           name="phone"/>
                </div>
            </div>
            <div class="row align-items-end">
                <div class="col">
                    <select class="form-select"
                            v-model="addedBy"
                            name="addedBy">
                        <option value="none" disabled selected>Added by...</option>
                        <option value="Cojusnean Mihai">Cojusnean Mihai</option>
                        <option value="Kovalsky Liubomir">Kovalsky Liubomir</option>
                    </select>
                </div>
                <div class="d-grid col mx-auto">
                    <button type="submit" class="btn btn-lg" @click="create">Save</button>
                </div>
            </div>
        </form>
    </div>
</template>

<script>
import { ValidationProvider } from "vee-validate";
export default {
    components: {
      ValidationProvider
    },
    props: ['countries'],
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
            addedBy: 'none'
        }
    },
    methods: {
        create() {
            // this.$validator.validateAll().then((result) => {
            //     if (result) {
            //         alert('Form Submitted!');
            //         return;
            //     }
            //
            //     alert('Correct them errors!');
            // });

            const form = document.querySelector("#form");
            const body = Object.fromEntries(new FormData(form));
            body['country'] = this.country.name

            this.$store.dispatch('peopleStore/addPerson', body)

            this.id = this.firstName = this.lastName = this.dateOfBirth = this.gender
                = this.email = this.address = this.phone = ''
            this.country = this.city = this.addedBy = 'none'
        },
        setCities() {
            this.city = 'none'
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

.position-relative-example div {
    width: 2em;
    height: 2em;
    background-color: #343a40;
    border-radius: .25rem;
}
</style>