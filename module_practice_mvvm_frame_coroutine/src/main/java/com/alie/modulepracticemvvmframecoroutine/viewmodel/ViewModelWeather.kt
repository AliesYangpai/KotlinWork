package com.alie.modulepracticemvvmframecoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alie.modulepracticemvvmframecoroutine.data.http.HttpThirdResponse
import com.alie.modulepracticemvvmframecoroutine.data.third.WeatherBean
import com.alie.modulepracticemvvmframecoroutine.repo.RepoWeather
import kotlinx.coroutines.launch

class ViewModelWeather : ViewModel() {
    private val mRepoWeather by lazy { RepoWeather() }
    val mLiveDataWeather by lazy { MutableLiveData<Result<HttpThirdResponse<WeatherBean?>?>>() }

    fun loadWeather(cityCode: String = "101010100") {
        viewModelScope.launch {
            val result = try {
                mRepoWeather.loadWeather(cityCode).let { Result.success(it) }
            } catch (e: Exception) {
                Result.failure(e)
            }
            mLiveDataWeather.value = result;
        }
    }
}