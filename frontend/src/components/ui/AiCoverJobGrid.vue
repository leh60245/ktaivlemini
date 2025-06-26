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
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="startAiCoverGenerationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 커버 이미지 생성 시작
                </v-btn>
                <v-dialog v-model="startAiCoverGenerationDialog" width="500">
                    <StartAiCoverGeneration
                        @closeDialog="startAiCoverGenerationDialog = false"
                        @startAiCoverGeneration="startAiCoverGeneration"
                    ></StartAiCoverGeneration>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="failAiCoverGenerationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 커버 이미지 생성 실패
                </v-btn>
                <v-dialog v-model="failAiCoverGenerationDialog" width="500">
                    <FailAiCoverGeneration
                        @closeDialog="failAiCoverGenerationDialog = false"
                        @failAiCoverGeneration="failAiCoverGeneration"
                    ></FailAiCoverGeneration>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="createAiCoverJobDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 커버 생성 작업 요청
                </v-btn>
                <v-dialog v-model="createAiCoverJobDialog" width="500">
                    <CreateAiCoverJob
                        @closeDialog="createAiCoverJobDialog = false"
                        @createAiCoverJob="createAiCoverJob"
                    ></CreateAiCoverJob>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="completeAiCoverGenerationDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 커버 이미지 생성 완료
                </v-btn>
                <v-dialog v-model="completeAiCoverGenerationDialog" width="500">
                    <CompleteAiCoverGeneration
                        @closeDialog="completeAiCoverGenerationDialog = false"
                        @completeAiCoverGeneration="completeAiCoverGeneration"
                    ></CompleteAiCoverGeneration>
                </v-dialog>
            </div>
            <AiCoverJobDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AiCoverJobDetails>
            <AiCoverJobList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AiCoverJobList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Status</th>
                        <th>ImageInfo</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>PublicationRequestId</th>
                        <th>PublicationRequestId</th>
                        <th>PublicationRequestId</th>
                        <th>출간 요청</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="ImageInfo">{{ val.imageInfo }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="PublicationRequestId">{{ val.publicationRequestId }}</td>
                            <td class="whitespace-nowrap" label="PublicationRequestId">{{ val.publicationRequestId }}</td>
                            <td class="whitespace-nowrap" label="PublicationRequestId">{{ val.publicationRequestId }}</td>
                            <td class="whitespace-nowrap" label="출간 요청">
                                <PublicationRequestId :editMode="editMode" v-model="val.publicationRequestId"></PublicationRequestId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">AiCoverJob 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <AiCoverJob :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">AiCoverJob 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="JobId" v-model="selectedRow.jobId" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <AICoverJobStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <AICoverImageInfo offline label="ImageInfo" v-model="selectedRow.imageInfo" :editMode="true"/>
                            <PublicationRequestId offline label="PublicationRequestId" v-model="selectedRow.publicationRequestId" :editMode="true"/>
                            <PublicationRequestId offline label="PublicationRequestId" v-model="selectedRow.publicationRequestId" :editMode="true"/>
                            <PublicationRequestId offline label="PublicationRequestId" v-model="selectedRow.publicationRequestId" :editMode="true"/>
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
    name: 'aiCoverJobGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'aiCoverJobs',
        startAiCoverGenerationDialog: false,
        failAiCoverGenerationDialog: false,
        createAiCoverJobDialog: false,
        completeAiCoverGenerationDialog: false,
    }),
    watch: {
    },
    methods:{
        async startAiCoverGeneration(params){
            try{
                var path = "startAiCoverGeneration".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','StartAICoverGeneration 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.startAiCoverGenerationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async failAiCoverGeneration(params){
            try{
                var path = "failAiCoverGeneration".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','FailAICoverGeneration 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.failAiCoverGenerationDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async createAiCoverJob(params){
            try{
                var path = "createAiCoverJob".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CreateAICoverJob 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.createAiCoverJobDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async completeAiCoverGeneration(params){
            try{
                var path = "completeAiCoverGeneration".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CompleteAICoverGeneration 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.completeAiCoverGenerationDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>