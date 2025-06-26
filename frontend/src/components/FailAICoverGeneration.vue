<template>

    <v-card outlined>
        <v-card-title>
            FailAiCoverGeneration
        </v-card-title>

        <v-card-text>
            <Number label="JobId" v-model="value.jobId" :editMode="editMode"/>
            <String label="FailureReason" v-model="value.failureReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="failAiCoverGeneration"
            >
                FailAiCoverGeneration
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
    name: 'FailAiCoverGenerationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.jobId = 0;
        this.value.failureReason = '';
    },
    watch: {
    },
    methods: {
        failAiCoverGeneration() {
            this.$emit('failAiCoverGeneration', this.value);
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

