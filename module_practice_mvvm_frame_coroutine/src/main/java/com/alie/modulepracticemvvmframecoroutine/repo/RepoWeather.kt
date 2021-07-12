package com.alie.modulepracticemvvmframecoroutine.repo

import com.alie.modulepracticemvvmframecoroutine.api.ApiHttpClient
import com.alie.modulepracticemvvmframecoroutine.api.service.ServiceWeather

class RepoWeather {
    suspend fun loadWeather(cityCode: String = "101010100") =
        ApiHttpClient.getInstance().generateService(ServiceWeather::class.java)
            ?.loadWeather(cityCode)
}