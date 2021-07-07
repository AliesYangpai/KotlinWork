package com.alie.modulepracticemvvmframe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alie.modulepracticemvvmframe.data.CarBean
import com.alie.modulepracticemvvmframe.data.CarFrameBean
import com.alie.modulepracticemvvmframe.data.EngineBean
import com.alie.modulepracticemvvmframe.data.WheelBean
import com.alie.modulepracticemvvmframe.repo.RepoCar

class CarViewModel:ViewModel() {

    val mCarLiveData:MutableLiveData<CarBean> by lazy { MutableLiveData<CarBean>() }
    val mEngineLiveData by lazy { MutableLiveData<EngineBean>() }
    val mCarFrameLiveData by lazy { MutableLiveData<CarFrameBean> () }
    val mWheelLiveData by lazy { MutableLiveData<WheelBean>() }

    private val mRepoCar:RepoCar by lazy { RepoCar() }


    fun loadDataCar(){
        mCarLiveData.value = mRepoCar.loadCarBean()
    }
    fun loadDataEngine(){
        mEngineLiveData.value = mRepoCar.loadEngineBean()
    }
    fun loadDataCarFrame() {
        mCarFrameLiveData.value = mRepoCar.loadCarFrameBean()
    }
    fun loadDataWheel() {
        mWheelLiveData.value = mRepoCar.loadWheelBean()
    }
}