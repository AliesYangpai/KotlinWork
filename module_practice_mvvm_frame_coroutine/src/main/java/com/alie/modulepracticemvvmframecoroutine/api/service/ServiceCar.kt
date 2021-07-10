package com.alie.modulepracticemvvmframecoroutine.api.service

import com.alie.modulepracticemvvmframecoroutine.api.ConstHttpUrl
import com.alie.modulepracticemvvmframecoroutine.data.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.WheelBean
import retrofit2.http.GET

interface ServiceCar {
    @GET(ConstHttpUrl.SUFFIX_CAR)
    suspend fun loadCar():CarBean?

    @GET(ConstHttpUrl.SUFFIX_ENGINE)
    suspend fun loadEngine():EngineBean?

    @GET(ConstHttpUrl.SUFFIX_CAR_FRAME)
    suspend fun loadCarFrame():CarFrameBean?

    @GET(ConstHttpUrl.SUFFIX_WHEEL)
    suspend fun loadWheel():WheelBean?
}