package com.alie.modulepracticemvvmframecoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alie.modulepracticemvvmframecoroutine.data.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.WheelBean
import com.alie.modulepracticemvvmframecoroutine.repo.RepoCar

class ViewModelCar : ViewModel() {

    private val mRepoCar: RepoCar by lazy { RepoCar() }


    val mLiveDataCar: MutableLiveData<CarBean> by lazy { MutableLiveData<CarBean>() }
    val mLiveDataEngine by lazy { MutableLiveData<EngineBean>() }
    val mLiveDataCarFrame by lazy { MutableLiveData<CarFrameBean>() }
    val mLiveDataWheel by lazy { MutableLiveData<WheelBean>() }

    fun loadCar() {
        mLiveDataCar.value = mRepoCar.loadDataCar()
    }

    fun loadEngine() {
        mLiveDataEngine.value = mRepoCar.loadDataEngine()
    }

    fun loadCarFrame() {
        mLiveDataCarFrame.value = mRepoCar.loadDataCarFrame()
    }

    fun loadWheel() {
        mLiveDataWheel.value = mRepoCar.loadDataWheel()
    }
}