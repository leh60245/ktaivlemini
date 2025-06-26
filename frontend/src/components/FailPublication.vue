<template>

    <v-card outlined>
        <v-card-title>
            FailPublication
        </v-card-title>

        <v-card-text>
            <Number label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode"/>
            <String label="FailureReason" v-model="value.failureReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="failPublication"
            >
                FailPublication
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
    name: 'FailPublicationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationRequestId = 0;
        this.value.failureReason = '';
    },
    watch: {
    },
    methods: {
        failPublication() {
            this.$emit('failPublication', this.value);
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

