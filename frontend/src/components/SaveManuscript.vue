<template>

    <v-card outlined>
        <v-card-title>
            SaveManuscript
        </v-card-title>

        <v-card-text>
            <Number label="ManuscriptId" v-model="value.manuscriptId" :editMode="editMode"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
            <ManuscriptType offline label="Type" v-model="value.type" :editMode="editMode" @change="change"/>
            <SaveType offline label="SaveType" v-model="value.saveType" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="saveManuscript"
            >
                SaveManuscript
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
    name: 'SaveManuscriptCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.manuscriptId = 0;
        this.value.title = '';
        this.value.content = '';
        this.value.type = {};
        this.value.saveType = {};
    },
    watch: {
    },
    methods: {
        saveManuscript() {
            this.$emit('saveManuscript', this.value);
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

