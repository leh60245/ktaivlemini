<template>
    <div>
        <Number
            label="JobId"
            v-model="value.jobId"
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
        <AICoverJobStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <AICoverImageInfo
            offline
            label="ImageInfo"
            v-model="value.imageInfo"
            :editMode="editMode"
            @change="change"
        />
        <PublicationRequestId
            offline
            label="PublicationRequestId"
            v-model="value.publicationRequestId"
            :editMode="editMode"
            @change="change"
        />
        <PublicationRequestId
            offline
            label="PublicationRequestId"
            v-model="value.publicationRequestId"
            :editMode="editMode"
            @change="change"
        />
        <PublicationRequestId
            offline
            label="PublicationRequestId"
            v-model="value.publicationRequestId"
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
    name: 'AiCoverJob',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "aiCoverJobs",
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
