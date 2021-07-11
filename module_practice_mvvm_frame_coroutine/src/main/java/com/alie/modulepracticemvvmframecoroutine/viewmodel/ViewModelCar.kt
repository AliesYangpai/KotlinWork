package com.alie.modulepracticemvvmframecoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alie.modulepracticemvvmframecoroutine.data.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.WheelBean
import com.alie.modulepracticemvvmframecoroutine.data.http.HttpResponse
import com.alie.modulepracticemvvmframecoroutine.repo.RepoCar
import kotlinx.coroutines.launch

class ViewModelCar : ViewModel() {

    private val mRepoCar: RepoCar by lazy { RepoCar() }


    val mLiveDataCar: MutableLiveData<Result<HttpResponse<CarBean?>?>> by lazy { MutableLiveData<Result<HttpResponse<CarBean?>?>>() }
    val mLiveDataEngine by lazy { MutableLiveData<Result<HttpResponse<EngineBean?>?>>() }
    val mLiveDataCarFrame by lazy { MutableLiveData<Result<HttpResponse<CarFrameBean?>?>>() }
    val mLiveDataWheel by lazy { MutableLiveData<Result<HttpResponse<WheelBean?>?>>() }

    fun loadCar() {
//        viewModelScope.launch {
//            println(" Thread:${Thread.currentThread().name}")
//            mRepoCar.loadDataCar().let {
//                println(" Thread:${Thread.currentThread().name}")
//                mLiveDataCar.value = it }
//        }

        /**
         * try-catch use here
         * try-catch 最为返回值的表达式时，返回的值是try或catch的最后一行，finally中的内容不影响表达式的结果
         */
        viewModelScope.launch {
            val result = try {
                mRepoCar.loadDataCar().let { Result.success(it) }
            } catch (e: Exception) {
                Result.failure(e)
            }
            mLiveDataCar.value = result
        }
    }

    fun loadEngine() {
        viewModelScope.launch {
            val result = try {
                mRepoCar.loadDataEngine().let { Result.success(it) }
            } catch (e: Exception) {
                Result.failure(e)
            }
            mLiveDataEngine.value = result
        }
    }


    fun loadCarFrame() {
        viewModelScope.launch {
            val result =  try {
                mRepoCar.loadDataCarFrame().let { Result.success(it) }
            } catch (e: Exception) {
                Result.failure(e)
            }
            mLiveDataCarFrame.value = result
        }
    }

    fun loadWheel() {
        viewModelScope.launch {
           val result = try {
                mRepoCar.loadDataWheel().let { Result.success(it) }
            } catch (e: Exception) {
                Result.failure(e)
            }
            mLiveDataWheel.value =result
        }
    }
}