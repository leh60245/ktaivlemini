<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="activateSubscriptionDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>구독 활성화
                </v-btn>
                <v-dialog v-model="activateSubscriptionDialog" width="500">
                    <ActivateSubscription
                        @closeDialog="activateSubscriptionDialog = false"
                        @activateSubscription="activateSubscription"
                    ></ActivateSubscription>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="readBookWithSubscriptionDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>구독 도서 열람
                </v-btn>
                <v-dialog v-model="readBookWithSubscriptionDialog" width="500">
                    <ReadBookWithSubscription
                        @closeDialog="readBookWithSubscriptionDialog = false"
                        @readBookWithSubscription="readBookWithSubscription"
                    ></ReadBookWithSubscription>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="requestSubscriptionDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>구독 신청
                </v-btn>
                <v-dialog v-model="requestSubscriptionDialog" width="500">
                    <RequestSubscription
                        @closeDialog="requestSubscriptionDialog = false"
                        @requestSubscription="requestSubscription"
                    ></RequestSubscription>
                </v-dialog>
            </div>
            <BookReadHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BookReadHistory>
            <AdminSubscriberSummary @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AdminSubscriberSummary>
            <SubscriptionStatus @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SubscriptionStatus>
            <PointUsageHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PointUsageHistory>
            <SubscriberDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></SubscriberDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>IsKTUser</th>
                        <th>Points</th>
                        <th>SubscriptionStatus</th>
                        <th>BookId</th>
                        <th>도서</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Name">{{ val.name }}</td>
                            <td class="whitespace-nowrap" label="Email">{{ val.email }}</td>
                            <td class="whitespace-nowrap" label="IsKTUser">{{ val.isKTUser }}</td>
                            <td class="whitespace-nowrap" label="Points">{{ val.points }}</td>
                            <td class="whitespace-nowrap" label="SubscriptionStatus">{{ val.subscriptionStatus }}</td>
                            <td class="whitespace-nowrap" label="BookId">{{ val.bookId }}</td>
                            <td class="whitespace-nowrap" label="도서">
                                <BookId :editMode="editMode" v-model="val.bookId"></BookId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Subscriber 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Subscriber :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Subscriber 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="SubscriberId" v-model="selectedRow.subscriberId" :editMode="true"/>
                            <String label="Name" v-model="selectedRow.name" :editMode="true"/>
                            <String label="Email" v-model="selectedRow.email" :editMode="true"/>
                            <Boolean label="IsKTUser" v-model="selectedRow.isKTUser" :editMode="true"/>
                            <Number label="Points" v-model="selectedRow.points" :editMode="true"/>
                            <SubscriptionStatus offline label="SubscriptionStatus" v-model="selectedRow.subscriptionStatus" :editMode="true"/>
                            <BookId offline label="BookId" v-model="selectedRow.bookId" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'subscriberGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'subscribers',
        activateSubscriptionDialog: false,
        readBookWithSubscriptionDialog: false,
        requestSubscriptionDialog: false,
    }),
    watch: {
    },
    methods:{
        async activateSubscription(params){
            try{
                var path = "activateSubscription".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ActivateSubscription 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.activateSubscriptionDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async readBookWithSubscription(params){
            try{
                var path = "readBookWithSubscription".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ReadBookWithSubscription 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.readBookWithSubscriptionDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async requestSubscription(params){
            try{
                var path = "requestSubscription".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RequestSubscription 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.requestSubscriptionDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>