package com.alie.modulepracticemvvmframecoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alie.modulepracticemvvmframecoroutine.data.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.WheelBean
import com.alie.modulepracticemvvmframecoroutine.repo.RepoCar
import kotlinx.coroutines.launch

class ViewModelCar : ViewModel() {

    private val mRepoCar: RepoCar by lazy { RepoCar() }


    val mLiveDataCar: MutableLiveData<CarBean> by lazy { MutableLiveData<CarBean>() }
    val mLiveDataEngine by lazy { MutableLiveData<EngineBean>() }
    val mLiveDataCarFrame by lazy { MutableLiveData<CarFrameBean>() }
    val mLiveDataWheel by lazy { MutableLiveData<WheelBean>() }

    fun loadCar() {
        viewModelScope.launch {
            println(" Thread:${Thread.currentThread().name}")
            mRepoCar.loadDataCar().let {
                println(" Thread:${Thread.currentThread().name}")
                mLiveDataCar.value = it }
        }
    }

    fun loadEngine() {
        viewModelScope.launch {
            mRepoCar.loadDataEngine().let { mLiveDataEngine.value = it }
        }
    }


    fun loadCarFrame() {
       viewModelScope.launch {
           mRepoCar.loadDataCarFrame().let { mLiveDataCarFrame.value = it }
       }
    }

    fun loadWheel() {
      viewModelScope.launch {
          mRepoCar.loadDataWheel().let { mLiveDataWheel.value = it }
      }
    }
}