package com.alie.modulepracticemvvmframecoroutine.api.service

import com.alie.modulepracticemvvmframecoroutine.api.ConstHttpUrl
import com.alie.modulepracticemvvmframecoroutine.data.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.WheelBean
import com.alie.modulepracticemvvmframecoroutine.data.http.HttpResponse
import retrofit2.http.GET

interface ServiceCar:ServiceBase {
    @GET(ConstHttpUrl.SUFFIX_CAR)
    suspend fun loadCar():HttpResponse<CarBean?>?

    @GET(ConstHttpUrl.SUFFIX_ENGINE)
    suspend fun loadEngine():HttpResponse<EngineBean?>?

    @GET(ConstHttpUrl.SUFFIX_CAR_FRAME)
    suspend fun loadCarFrame():HttpResponse<CarFrameBean?>?

    @GET(ConstHttpUrl.SUFFIX_WHEEL)
    suspend fun loadWheel():HttpResponse<WheelBean?>?
}