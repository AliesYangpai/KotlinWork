package com.alie.surfacework.data

import com.alie.surfacework.source.CameraDeviceDataSource
import com.alie.surfacework.source.LightDeviceDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * surface的数据仓
 */
@Singleton
class SurfaceRepository @Inject constructor(
    private val lightDeviceDataSource: LightDeviceDataSource,
    private val cameraDeviceDataSource: CameraDeviceDataSource
) {
    fun fetchLightType(){
        lightDeviceDataSource.fetchLightType()
    }
    fun fetchCameraData(){
        cameraDeviceDataSource.fetchCameraData()
    }
}