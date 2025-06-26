<template>

    <v-card outlined>
        <v-card-title>
            CompletePublication
        </v-card-title>

        <v-card-text>
            <Number label="PublicationRequestId" v-model="value.publicationRequestId" :editMode="editMode"/>
            <String label="CoverImageUrl" v-model="value.coverImageUrl" :editMode="editMode"/>
            <Date label="PublishedDate" v-model="value.publishedDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="completePublication"
            >
                CompletePublication
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
    name: 'CompletePublicationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.publicationRequestId = 0;
        this.value.coverImageUrl = '';
        this.value.publishedDate = '2025-06-26';
    },
    watch: {
    },
    methods: {
        completePublication() {
            this.$emit('completePublication', this.value);
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

