package com.alie.surfacework.source

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CameraDeviceDataSource @Inject constructor(){
    fun fetchCameraData() {
        println("CameraDeviceDataSource fetchCameraData")
    }
}