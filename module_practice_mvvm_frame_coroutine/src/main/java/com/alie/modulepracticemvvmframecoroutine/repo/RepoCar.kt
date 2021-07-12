package com.alie.modulepracticemvvmframecoroutine.repo

import com.alie.modulepracticemvvmframecoroutine.api.ApiHttpClient
import com.alie.modulepracticemvvmframecoroutine.api.service.ServiceCar
import com.alie.modulepracticemvvmframecoroutine.data.local.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.local.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.local.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.http.HttpResponse

class RepoCar {

    private val mCarApi by lazy { ApiHttpClient.getInstance().generateService(ServiceCar::class.java) }

    suspend fun loadDataCar(): HttpResponse<CarBean?>? {
        return mCarApi?.loadCar()
    }
    suspend fun loadDataEngine(): HttpResponse<EngineBean?>? = mCarApi?.loadEngine()
    suspend fun loadDataCarFrame(): HttpResponse<CarFrameBean?>? = mCarApi?.loadCarFrame()
    suspend fun loadDataWheel() = mCarApi?.loadWheel()
}