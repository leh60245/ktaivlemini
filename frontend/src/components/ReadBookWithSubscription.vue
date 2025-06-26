<template>

    <v-card outlined>
        <v-card-title>
            ReadBookWithSubscription
        </v-card-title>

        <v-card-text>
            <Number label="SubscriberId" v-model="value.subscriberId" :editMode="editMode"/>
            <Number label="BookId" v-model="value.bookId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="readBookWithSubscription"
            >
                ReadBookWithSubscription
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
    name: 'ReadBookWithSubscriptionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = 0;
        this.value.bookId = 0;
    },
    watch: {
    },
    methods: {
        readBookWithSubscription() {
            this.$emit('readBookWithSubscription', this.value);
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

