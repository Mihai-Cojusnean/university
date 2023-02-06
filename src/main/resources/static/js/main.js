// import Vue from 'vue'
// import VueResource from 'vue-resource'
// import App from 'templates/App.vue'
//
// Vue.use(VueResource)
//
// new Vue({
//     el: '#app',
//     render: a => a(App)
// })

function getIndex(list, id) {
    for (let i = 0; i < list.length; i++)
        if (list[i].id === id) return i;

    return -1;
}

Vue.component('people-row', {
    props: ['people', 'editMethod', 'person'],
    template:
        '<tbody>' +
        '<tr>' +
           '<td> {{person.first_name}} </td>' +
           '<td> {{person.last_name}} </td>' +
           '<td> {{person.gender}} </td>' +
           '<td> {{person.date_of_birth}} </td>' +
           '<td> {{person.country}} </td>' +
           '<td> {{person.city}} </td>' +
           '<td> {{person.address}} </td>' +
           '<td> {{person.email}} </td>' +
           '<td> {{person.phone}} </td>' +
           '<td> {{person.form}} </td>' +
           '<td><input type="button" value="Edit" @click="edit"></td>' +
           '<td><input type="button" value="X" @click="del"></td>' +
        '</tr>' +
        '</tbody>',
    methods: {
        edit: function () {
            this.editMethod(this.person);
        },
        del: function () {
            fetch("/people/" + this.person.id, {
                method: 'DELETE',
            }).then(result => {
                if (result.ok) this.people.splice(this.people.indexOf(this.person), 1)
            })
        }
    }
});

Vue.component('person-form', {
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
    template:
        '<form id="my-form" class="col-md-4 col-md-offset-4">' +
        '<label>First name</label><input type="text" placeholder="Write your first name" v-model="first_name" />' +
        '<label>Last name</label><input type="text" placeholder="Write your last name" v-model="last_name" />' +
        '<label>Date of bith</label><input type="text" placeholder="Write your date of birth" v-model="date_of_birth" />' +
        '<label>Gender</label><input type="text" placeholder="Write your gender" v-model="gender" />' +
        '<label>Email</label><input type="text" placeholder="Write your email" v-model="email" />' +
        '<label>Adress</label><input type="text" placeholder="Write your adress" v-model="address" />' +
        '<label>Country</label><input type="text" placeholder="Write your country" v-model="country" />' +
        '<label>City</label><input type="text" placeholder="Write your city" v-model="city" />' +
        '<label>Phone</label><input type="text" placeholder="Write your phone" v-model="phone" />' +
        '<label>Form</label><input type="text" placeholder="Write your form" v-model="form" />' +
        '<input type="button" value="Save" @click="create" />' +
        '</form>',
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
})

Vue.component('people-list', {
    props: ['people'],
    data: function () {
        return {
            person: null
        }
    },
    template:
        '<div style="position: relative; width: 800px">' +
        '<person-form :people="people" :personAttr="person" />' +
        '<table class="table table-bordered table-hover">' +
        '<thead style="background-color: #858585; color: #152223">' +
        '<tr>' +
           '<th>First name</th>' +
           '<th>Last name</th>' +
           '<th>Gender</th>' +
           '<th>Date of birth</th>' +
           '<th>Country</th>' +
           '<th>City</th>' +
           '<th>Address</th>' +
           '<th>Email</th>' +
           '<th>Phone</th>' +
           '<th>Form</th>' +
           '<th>Edit</th>' +
           '<th>Delete</th>' +
        '</tr>' +
        '</thead>' +
        '<people-row v-for="person in people" :key="person.id" :person="person" ' +
        ':editMethod="editMethod" :people="people"/>' +
        '</table>' +
        '</div>',
    created: function () {
        fetch("/people").then(result => result.json()
            .then(data => data.forEach(person => this.people.push(person))))
    },
    methods: {
        editMethod: function (person) {
            this.person = person;
        }
    }
});

const app = new Vue({
    el: '#app', template: '<people-list :people="people" />', data: {
        people: []
    }
});