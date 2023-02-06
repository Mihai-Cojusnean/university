<template>
    <h1>Hello from peoplerow</h1>
    <tbody>
    <tr>
        <td>{{ person.first_name }}</td>
        <td>{{ person.last_name }}</td>
        <td>{{ person.gender }}</td>
        <td>{{ person.date_of_birth }}</td>
        <td>{{ person.country }}</td>
        <td>{{ person.city }}</td>
        <td>{{ person.address }}</td>
        <td>{{ person.email }}</td>
        <td>{{ person.phone }}</td>
        <td>{{ person.form }}</td>
        <td><input type="button" value="Edit" @click="edit"></td>
        <td><input type="button" value="X" @click="del"></td>
    </tr>
    </tbody>
</template>

<script>
export default {
    props: ['people', 'editMethod', 'person'],
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
}
</script>

<style scoped>
.item {
  margin-top: 2rem;
  display: flex;
}

.details {
  flex: 1;
  margin-left: 1rem;
}

i {
  display: flex;
  place-items: center;
  place-content: center;
  width: 32px;
  height: 32px;

  color: var(--color-text);
}

h3 {
  font-size: 1.2rem;
  font-weight: 500;
  margin-bottom: 0.4rem;
  color: var(--color-heading);
}

@media (min-width: 1024px) {
  .item {
    margin-top: 0;
    padding: 0.4rem 0 1rem calc(var(--section-gap) / 2);
  }

  i {
    top: calc(50% - 25px);
    left: -26px;
    position: absolute;
    border: 1px solid var(--color-border);
    background: var(--color-background);
    border-radius: 8px;
    width: 50px;
    height: 50px;
  }

  .item:before {
    content: ' ';
    border-left: 1px solid var(--color-border);
    position: absolute;
    left: 0;
    bottom: calc(50% + 25px);
    height: calc(50% - 25px);
  }

  .item:after {
    content: ' ';
    border-left: 1px solid var(--color-border);
    position: absolute;
    left: 0;
    top: calc(50% + 25px);
    height: calc(50% - 25px);
  }

  .item:first-of-type:before {
    display: none;
  }

  .item:last-of-type:after {
    display: none;
  }
}
</style>
