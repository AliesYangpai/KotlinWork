package com.alie.modulepracticemvvmframecoroutine.api.service

import com.alie.modulepracticemvvmframecoroutine.data.http.HttpThirdResponse
import com.alie.modulepracticemvvmframecoroutine.data.third.WeatherBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceWeather {
    @GET("data/sk/{cityCode}.html") // 此处默认是北京的天气
    suspend fun loadWeather(@Path("cityCode") cityCode:String):HttpThirdResponse<WeatherBean?>?
}