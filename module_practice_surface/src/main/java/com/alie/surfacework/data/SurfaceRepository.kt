package com.alie.surfacework.data

import com.alie.surfacework.source.CameraDeviceDataSource
import com.alie.surfacework.source.LightDeviceDataSource

/**
 * surface的数据仓
 */
class SurfaceRepository(
    private val lightDeviceDataSource: LightDeviceDataSource,
    private val cameraDeviceDataSource: CameraDeviceDataSource
) {
    fun fetchLightType(){}
    fun fetchCameraData(){}
}