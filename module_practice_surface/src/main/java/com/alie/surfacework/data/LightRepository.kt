package com.alie.surfacework.data

import com.alie.surfacework.source.LightDeviceDataSource

/**
 * 灯光数据仓-公开api
 * // todo 废弃 使用SurfaceRepository
 */
class LightRepository(
    private val lightDeviceDataSource: LightDeviceDataSource
) {
    fun fetchLightType(){}
}