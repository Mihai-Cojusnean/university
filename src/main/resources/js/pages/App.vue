<template>
    <peopleList></peopleList>
</template>

<script>
import PeopleList from "../components/PeopleList.vue";
import {sortTableByColumn} from "../logic/tableSort";

export default {
    components: {
        PeopleList
    },
    mounted() {
        const headers = document.querySelectorAll(".table th")
        headers.forEach(headerCell => {
            if (headerCell.textContent !== "Edit" && headerCell.textContent !== "Delete") {
                headerCell.addEventListener("click", () => {
                    const tableElement = headerCell.closest('table')
                    const headerIndex = Array.prototype.indexOf.call(headerCell.parentElement.children, headerCell)
                    const currIsAscending = headerCell.classList.contains("th-sort-asc")

                    sortTableByColumn(tableElement, headerIndex, !currIsAscending)
                })
            }
        })
    }
}
</script>

<style>
.table th {
    cursor: pointer;
}

.table .th-sort-asc::after {
    content: "\25b4";
}

.table .th-sort-desc::after {
    content: "\25be";
}

.table-sortable .th-sort-asc::after,
.table-sortable .th-sort-desc::after {
    margin-left: 5px;
}

.table .th-sort-asc,
.table .th-sort-desc {
    background: rgba(0, 0, 0, 0.1);
}
</style>