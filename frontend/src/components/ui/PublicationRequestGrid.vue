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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="failPublicationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 실패 처리
                </v-btn>
                <v-dialog v-model="failPublicationDialog" width="500">
                    <FailPublication
                        @closeDialog="failPublicationDialog = false"
                        @failPublication="failPublication"
                    ></FailPublication>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="completePublicationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 완료
                </v-btn>
                <v-dialog v-model="completePublicationDialog" width="500">
                    <CompletePublication
                        @closeDialog="completePublicationDialog = false"
                        @completePublication="completePublication"
                    ></CompletePublication>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="startPublicationProcessingDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 처리 시작
                </v-btn>
                <v-dialog v-model="startPublicationProcessingDialog" width="500">
                    <StartPublicationProcessing
                        @closeDialog="startPublicationProcessingDialog = false"
                        @startPublicationProcessing="startPublicationProcessing"
                    ></StartPublicationProcessing>
                </v-dialog>
            </div>
            <PublicationRequestList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationRequestList>
            <PublicationRequestDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></PublicationRequestDetails>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ManuscriptId</th>
                        <th>Summary</th>
                        <th>CoverImageUrl</th>
                        <th>Format</th>
                        <th>Status</th>
                        <th>PublishedDate</th>
                        <th>CreatedDate</th>
                        <th>UpdatedDate</th>
                        <th>원고</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ManuscriptId">{{ val.manuscriptId }}</td>
                            <td class="whitespace-nowrap" label="Summary">{{ val.summary }}</td>
                            <td class="whitespace-nowrap" label="CoverImageUrl">{{ val.coverImageUrl }}</td>
                            <td class="whitespace-nowrap" label="Format">{{ val.format }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="PublishedDate">{{ val.publishedDate }}</td>
                            <td class="whitespace-nowrap" label="CreatedDate">{{ val.createdDate }}</td>
                            <td class="whitespace-nowrap" label="UpdatedDate">{{ val.updatedDate }}</td>
                            <td class="whitespace-nowrap" label="원고">
                                <ManuscriptId :editMode="editMode" v-model="val.manuscriptId"></ManuscriptId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationRequest 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <PublicationRequest :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">PublicationRequest 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="PublicationRequestId" v-model="selectedRow.publicationRequestId" :editMode="true"/>
                            <String label="Summary" v-model="selectedRow.summary" :editMode="true"/>
                            <String label="CoverImageUrl" v-model="selectedRow.coverImageUrl" :editMode="true"/>
                            <Date label="PublishedDate" v-model="selectedRow.publishedDate" :editMode="true"/>
                            <Date label="CreatedDate" v-model="selectedRow.createdDate" :editMode="true"/>
                            <Date label="UpdatedDate" v-model="selectedRow.updatedDate" :editMode="true"/>
                            <ManuscriptId offline label="ManuscriptId" v-model="selectedRow.manuscriptId" :editMode="true"/>
                            <PublicationFormat offline label="Format" v-model="selectedRow.format" :editMode="true"/>
                            <PublicationRequestStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'publicationRequestGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'publicationRequests',
        failPublicationDialog: false,
        completePublicationDialog: false,
        startPublicationProcessingDialog: false,
    }),
    watch: {
    },
    methods:{
        async failPublication(params){
            try{
                var path = "failPublication".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','FailPublication 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.failPublicationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async completePublication(params){
            try{
                var path = "completePublication".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CompletePublication 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.completePublicationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async startPublicationProcessing(params){
            try{
                var path = "startPublicationProcessing".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','StartPublicationProcessing 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.startPublicationProcessingDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>