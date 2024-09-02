<template>

    <v-data-table
        :headers="headers"
        :items="dashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "fileId", value: "fileId" },
                { text: "indexId", value: "indexId" },
                { text: "streamingId", value: "streamingId" },
                { text: "fileName", value: "fileName" },
                { text: "fileSize", value: "fileSize" },
                { text: "uploadYn", value: "uploadYn" },
                { text: "indexYn", value: "indexYn" },
                { text: "streamingUrl", value: "streamingUrl" },
            ],
            dashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dashboards'))

            temp.data._embedded.dashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dashboard = temp.data._embedded.dashboards;
        },
        methods: {
        }
    }
</script>

