package com.alie.surfacework.source

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LightDeviceDataSource @Inject constructor() {
    fun fetchLightType() {
        println("LightDeviceDataSource fetchLightType")
    }
}