<template>
    <div>
        <Number
            label="WalletId"
            v-model="value.walletId"
            :editMode="editMode"
        />
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <Boolean
            label="KtCustomer"
            v-model="value.ktCustomer"
            :editMode="editMode"
        />
        <Number
            label="PointBalance"
            v-model="value.pointBalance"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="UpdatedAt"
            v-model="value.updatedAt"
            :editMode="editMode"
        />
        <SubscriberId
            offline
            label="SubscriberId"
            v-model="value.subscriberId"
            :editMode="editMode"
            @change="change"
        />
        <WalletStatus
            offline
            label="Status"
            v-model="value.status"
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
    name: 'PointWallet',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "pointWallets",
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
