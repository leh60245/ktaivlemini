<template>

    <v-card outlined>
        <v-card-title>
            ReadBookWithPoints
        </v-card-title>

        <v-card-text>
            <Number label="WalletId" v-model="value.walletId" :editMode="editMode"/>
            <Number label="BookId" v-model="value.bookId" :editMode="editMode"/>
            <Number label="PointCost" v-model="value.pointCost" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="readBookWithPoints"
            >
                ReadBookWithPoints
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
    name: 'ReadBookWithPointsCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.walletId = 0;
        this.value.bookId = 0;
        this.value.pointCost = 0;
    },
    watch: {
    },
    methods: {
        readBookWithPoints() {
            this.$emit('readBookWithPoints', this.value);
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

