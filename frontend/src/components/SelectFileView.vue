<template>

    <v-data-table
        :headers="headers"
        :items="selectFile"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SelectFileView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            selectFile : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/selectFiles'))

            temp.data._embedded.selectFiles.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.selectFile = temp.data._embedded.selectFiles;
        },
        methods: {
        }
    }
</script>

