<template>

    <v-card outlined>
        <v-card-title>
            StartAiCoverGeneration
        </v-card-title>

        <v-card-text>
            <Number label="JobId" v-model="value.jobId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="startAiCoverGeneration"
            >
                StartAiCoverGeneration
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
    name: 'StartAiCoverGenerationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.jobId = 0;
    },
    watch: {
    },
    methods: {
        startAiCoverGeneration() {
            this.$emit('startAiCoverGeneration', this.value);
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

