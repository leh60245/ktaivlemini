<template>

    <v-card outlined>
        <v-card-title>
            CreateAiCoverJob
        </v-card-title>

        <v-card-text>
            <PublicationRequestId offline label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createAiCoverJob"
            >
                CreateAiCoverJob
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'CreateAiCoverJobCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationRequestId = {};
    },
    watch: {
    },
    methods: {
        createAiCoverJob() {
            this.$emit('createAiCoverJob', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

