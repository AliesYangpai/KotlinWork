package com.alie.surfacework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alie.surfacework.data.SurfaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val surfaceRepository: SurfaceRepository
) : ViewModel() {


    private val _liveDataLight = MutableLiveData<Int>()
    val liveDataLight: LiveData<Int> = _liveDataLight

    fun startLightBreath() {
        surfaceRepository.fetchLightType()
    }

    fun startCamera() {
        surfaceRepository.fetchCameraData()
    }
}