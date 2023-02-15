<template>
    <div>
        <form class="row g-3">
            <div class="col-md-6">
                <label class="form-label">First name</label>
                <input type="text" class="form-control" placeholder="Write your first name" v-model="first_name"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Last name</label>
                <input type="text" class="form-control" placeholder="Write your first name" v-model="last_name"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Date of birth</label>
                <input type="text" class="form-control" placeholder="dd/mm/yyyy" v-model="date_of_birth"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Gender</label>
                <input type="text" class="form-control" placeholder="Male or female" v-model="gender"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" placeholder="Write your address" v-model="address"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Country</label>
                <input type="text" class="form-control" placeholder="Write your country" v-model="country"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">City</label>
                <input type="text" class="form-control" placeholder="Write the city you from" v-model="city"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" placeholder="example@mail.com" v-model="email"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Phone number</label>
                <input type="number" class="form-control" placeholder="Write the city you from" v-model="phone"/>
            </div>
            <div class="col-md-6">
                <label class="form-label">Form</label>
                <input type="text" class="form-control" placeholder="example@mail.com" v-model="form"/>
            </div>
            <div class="d-grid justify-content-md-end" id="button">
                <button type="button" class="btn btn-success" @click="create">Save</button>
            </div>
        </form>
    </div>
</template>

<script>
function getIndex(list, id) {
    for (let i = 0; i < list.length; i++)
        if (list[i].id === id) return i;
    return -1;
}
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

<style>
#button {
    padding-bottom: 15px;
}
</style>