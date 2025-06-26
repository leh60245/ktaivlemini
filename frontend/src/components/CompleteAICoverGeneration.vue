<template>

    <v-card outlined>
        <v-card-title>
            CompleteAiCoverGeneration
        </v-card-title>

        <v-card-text>
            <Number label="JobId" v-model="value.jobId" :editMode="editMode"/>
            <AICoverImageInfo offline label="ImageInfo" v-model="value.imageInfo" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="completeAiCoverGeneration"
            >
                CompleteAiCoverGeneration
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
    name: 'CompleteAiCoverGenerationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.jobId = 0;
        this.value.imageInfo = {};
    },
    watch: {
    },
    methods: {
        completeAiCoverGeneration() {
            this.$emit('completeAiCoverGeneration', this.value);
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

