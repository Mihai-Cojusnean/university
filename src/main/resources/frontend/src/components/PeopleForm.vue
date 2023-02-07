<template>
    <h1>Hello from people form</h1>
    <form id="my-form" class="col-md-4 col-md-offset-4">
        <label>First name</label>
        <input type="text" placeholder="Write your first name" v-model="first_name"/>
        <label>Last name</label>
        <input type="text" placeholder="Write your last name" v-model="last_name"/>
        <label>Date of birth</label>
        <input type="text" placeholder="Write your date of birth" v-model="date_of_birth"/>
        <label>Gender</label>
        <input type="text" placeholder="Write your gender" v-model="gender"/>
        <label>Email</label>
        <input type="text" placeholder="Write your email" v-model="email"/>
        <label>Address</label>
        <input type="text" placeholder="Write your address" v-model="address"/>
        <label>Country</label>
        <input type="text" placeholder="Write your country" v-model="country"/>
        <label>City</label>
        <input type="text" placeholder="Write your city" v-model="city"/>
        <label>Phone</label>
        <input type="text" placeholder="Write your phone" v-model="phone"/>
        <label>Form</label>
        <input type="text" placeholder="Write your form" v-model="form"/>
        <input type="button" value="Save" @click="create"/>
    </form>
</template>

<script >
export default {
    props: ['people', 'personAttr'],
    data: function () {
        return {
            id: '',
            first_name: '',
            last_name: '',
            date_of_birth: '',
            gender: '',
            email: '',
            address: '',
            country: '',
            city: '',
            phone: '',
            form: ''
        }
    },
    watch: {
        personAttr: function (newVal) {
            this.id = newVal.id
            this.first_name = newVal.first_name
            this.last_name = newVal.last_name
            this.date_of_birth = newVal.date_of_birth
            this.gender = newVal.gender
            this.email = newVal.email
            this.address = newVal.address
            this.country = newVal.country
            this.city = newVal.city
            this.phone = newVal.phone
            this.form = newVal.form
        }
    },
    methods: {
        create: function (event) {
            let body = JSON.stringify({
                id: this.id,
                first_name: this.first_name,
                last_name: this.last_name,
                date_of_birth: this.date_of_birth,
                gender: this.gender,
                email: this.email,
                address: this.address,
                country: this.country,
                city: this.city,
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
                fetch("/people", {
                    method: "POST",
                    headers: {"Content-Type": "application/json"},
                    body: body
                }).then(response => response.json().then(data => {
                    this.people.push(data);
                }));
            }
            this.id = this.first_name = this.last_name = this.date_of_birth = this.gender
                = this.email = this.address = this.country = this.city = this.phone = this.form = ''
        }
    }
}
</script>