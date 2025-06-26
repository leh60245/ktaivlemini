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
                <v-btn style="margin-left: 5px;" @click="registerBookAutoDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>AI 자동 도서 등록
                </v-btn>
                <v-dialog v-model="registerBookAutoDialog" width="500">
                    <RegisterBookAuto
                        @closeDialog="registerBookAutoDialog = false"
                        @registerBookAuto="registerBookAuto"
                    ></RegisterBookAuto>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="readBookDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Subscriber')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>도서 열람
                </v-btn>
                <v-dialog v-model="readBookDialog" width="500">
                    <ReadBook
                        @closeDialog="readBookDialog = false"
                        @readBook="readBook"
                    ></ReadBook>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="designateBookAsBestsellerDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>베스트셀러 자동 지정
                </v-btn>
                <v-dialog v-model="designateBookAsBestsellerDialog" width="500">
                    <DesignateBookAsBestseller
                        @closeDialog="designateBookAsBestsellerDialog = false"
                        @designateBookAsBestseller="designateBookAsBestseller"
                    ></DesignateBookAsBestseller>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="createBookPublishingRequestDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Author')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>출간 요청 생성
                </v-btn>
                <v-dialog v-model="createBookPublishingRequestDialog" width="500">
                    <CreateBookPublishingRequest
                        @closeDialog="createBookPublishingRequestDialog = false"
                        @createBookPublishingRequest="createBookPublishingRequest"
                    ></CreateBookPublishingRequest>
                </v-dialog>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="publishBookDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('System')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>도서 출간 완료
                </v-btn>
                <v-dialog v-model="publishBookDialog" width="500">
                    <PublishBook
                        @closeDialog="publishBookDialog = false"
                        @publishBook="publishBook"
                    ></PublishBook>
                </v-dialog>
            </div>
            <BookDetails @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BookDetails>
            <BestsellerBookList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BestsellerBookList>
            <BookList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></BookList>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Summary</th>
                        <th>Keywords</th>
                        <th>CoverImageUrl</th>
                        <th>Category</th>
                        <th>SubscriptionFee</th>
                        <th>Status</th>
                        <th>ReadCount</th>
                        <th>BestsellerBadge</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="Title">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="Summary">{{ val.summary }}</td>
                            <td class="whitespace-nowrap" label="Keywords">{{ val.keywords }}</td>
                            <td class="whitespace-nowrap" label="CoverImageUrl">{{ val.coverImageUrl }}</td>
                            <td class="whitespace-nowrap" label="Category">{{ val.category }}</td>
                            <td class="whitespace-nowrap" label="SubscriptionFee">{{ val.subscriptionFee }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="ReadCount">{{ val.readCount }}</td>
                            <td class="whitespace-nowrap" label="BestsellerBadge">{{ val.bestsellerBadge }}</td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Book 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Book :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Book 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="BookId" v-model="selectedRow.bookId" :editMode="true"/>
                            <String label="Title" v-model="selectedRow.title" :editMode="true"/>
                            <String label="Summary" v-model="selectedRow.summary" :editMode="true"/>
                            <String label="Keywords" v-model="selectedRow.keywords" :editMode="true"/>
                            <String label="CoverImageUrl" v-model="selectedRow.coverImageUrl" :editMode="true"/>
                            <String label="Category" v-model="selectedRow.category" :editMode="true"/>
                            <Number label="SubscriptionFee" v-model="selectedRow.subscriptionFee" :editMode="true"/>
                            <Number label="ReadCount" v-model="selectedRow.readCount" :editMode="true"/>
                            <Boolean label="BestsellerBadge" v-model="selectedRow.bestsellerBadge" :editMode="true"/>
                            <BookStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
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
    name: 'bookGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'books',
        registerBookAutoDialog: false,
        readBookDialog: false,
        designateBookAsBestsellerDialog: false,
        createBookPublishingRequestDialog: false,
        publishBookDialog: false,
    }),
    watch: {
    },
    methods:{
        async registerBookAuto(params){
            try{
                var path = "registerBookAuto".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','RegisterBookAuto 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.registerBookAutoDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async readBook(params){
            try{
                var path = "readBook".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','ReadBook 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.readBookDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async designateBookAsBestseller(params){
            try{
                var path = "designateBookAsBestseller".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','DesignateBookAsBestseller 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.designateBookAsBestsellerDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async createBookPublishingRequest(params){
            try{
                var path = "createBookPublishingRequest".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','CreateBookPublishingRequest 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.createBookPublishingRequestDialog = false
            }catch(e){
                console.log(e)
            }
        },
        async publishBook(params){
            try{
                var path = "publishBook".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','PublishBook 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.publishBookDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>