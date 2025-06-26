<template>
    <div>
        <Number
            label="SubscriberId"
            v-model="value.subscriberId"
            :editMode="editMode"
        />
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <Boolean
            label="IsKTUser"
            v-model="value.isKTUser"
            :editMode="editMode"
        />
        <Number
            label="Points"
            v-model="value.points"
            :editMode="editMode"
        />
        <SubscriptionStatus
            offline
            label="SubscriptionStatus"
            v-model="value.subscriptionStatus"
            :editMode="editMode"
            @change="change"
        />
        <BookId
            offline
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Subscriber',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscribers",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
