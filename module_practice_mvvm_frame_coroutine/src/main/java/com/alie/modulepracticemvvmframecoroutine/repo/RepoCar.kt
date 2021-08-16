package com.alie.modulepracticemvvmframecoroutine.repo

import com.alie.modulepracticemvvmframecoroutine.api.ApiHttpClient
import com.alie.modulepracticemvvmframecoroutine.api.service.ServiceCar
import com.alie.modulepracticemvvmframecoroutine.data.local.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.local.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.local.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.http.HttpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoCar {

    private val mCarApi by lazy { ApiHttpClient.getInstance().generateService(ServiceCar::class.java) }

    suspend fun loadDataCar(): HttpResponse<CarBean?>? {
        return withContext(Dispatchers.IO) {
            mCarApi?.loadCar()
        }
    }
    suspend fun loadDataEngine(): HttpResponse<EngineBean?>? = withContext(Dispatchers.IO) {
        mCarApi?.loadEngine()
    }
    suspend fun loadDataCarFrame(): HttpResponse<CarFrameBean?>? = withContext(Dispatchers.IO) {
        mCarApi?.loadCarFrame()
    }
    suspend fun loadDataWheel() = withContext(Dispatchers.IO) {
        mCarApi?.loadWheel()
    }
}