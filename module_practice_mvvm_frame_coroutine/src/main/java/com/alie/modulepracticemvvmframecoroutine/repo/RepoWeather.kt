package com.alie.modulepracticemvvmframecoroutine.repo

import com.alie.modulepracticemvvmframecoroutine.api.ApiHttpClient
import com.alie.modulepracticemvvmframecoroutine.api.service.ServiceWeather
import com.alie.modulepracticemvvmframecoroutine.data.http.HttpThirdResponse
import com.alie.modulepracticemvvmframecoroutine.data.third.WeatherBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepoWeather {

    private val mWeatherApi by lazy {
        ApiHttpClient.getInstance().generateService(ServiceWeather::class.java)
    }

    suspend fun loadWeather(cityCode: String = "101010100") = withContext(Dispatchers.IO) {
        mWeatherApi?.loadWeather(cityCode)
    }
    


}