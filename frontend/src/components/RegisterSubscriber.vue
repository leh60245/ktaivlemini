<template>

    <v-card outlined>
        <v-card-title>
            RegisterSubscriber
        </v-card-title>

        <v-card-text>
            <Number label="SubscriberId" v-model="value.subscriberId" :editMode="editMode"/>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <Boolean label="KtCustomer" v-model="value.ktCustomer" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="registerSubscriber"
            >
                RegisterSubscriber
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
    name: 'RegisterSubscriberCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.subscriberId = 0;
        this.value.name = '';
        this.value.ktCustomer = false;
    },
    watch: {
    },
    methods: {
        registerSubscriber() {
            this.$emit('registerSubscriber', this.value);
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

