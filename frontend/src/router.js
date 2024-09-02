
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DriveDriveManager from "./components/listers/DriveDriveCards"
import DriveDriveDetail from "./components/listers/DriveDriveDetail"

import IndexerIndexManager from "./components/listers/IndexerIndexCards"
import IndexerIndexDetail from "./components/listers/IndexerIndexDetail"

import VideoProcessingVideoProcessManager from "./components/listers/VideoProcessingVideoProcessCards"
import VideoProcessingVideoProcessDetail from "./components/listers/VideoProcessingVideoProcessDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/drives/drives',
                name: 'DriveDriveManager',
                component: DriveDriveManager
            },
            {
                path: '/drives/drives/:id',
                name: 'DriveDriveDetail',
                component: DriveDriveDetail
            },

            {
                path: '/indexers/indices',
                name: 'IndexerIndexManager',
                component: IndexerIndexManager
            },
            {
                path: '/indexers/indices/:id',
                name: 'IndexerIndexDetail',
                component: IndexerIndexDetail
            },

            {
                path: '/videoProcessings/videoProcesses',
                name: 'VideoProcessingVideoProcessManager',
                component: VideoProcessingVideoProcessManager
            },
            {
                path: '/videoProcessings/videoProcesses/:id',
                name: 'VideoProcessingVideoProcessDetail',
                component: VideoProcessingVideoProcessDetail
            },





    ]
})
