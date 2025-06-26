<template>

    <v-card outlined>
        <v-card-title>
            StartPublicationProcessing
        </v-card-title>

        <v-card-text>
            <Number label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="startPublicationProcessing"
            >
                StartPublicationProcessing
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
    name: 'StartPublicationProcessingCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationRequestId = 0;
    },
    watch: {
    },
    methods: {
        startPublicationProcessing() {
            this.$emit('startPublicationProcessing', this.value);
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

