package com.alie.modulepracticemvvmframecoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alie.modulepracticemvvmframecoroutine.viewmodel.ViewModelCar
import com.alie.modulepracticemvvmframecoroutine.viewmodel.ViewModelWeather
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.time.measureTimedValue

class MainActivity : AppCompatActivity() {


    private val mViewModelCar by viewModels<ViewModelCar>()
    private val mViewModelWeather by viewModels<ViewModelWeather>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObserve()
        initViews()
    }

    private fun initObserve() {
        mViewModelCar.mLiveDataCar.observe(this,{
            mTvInfo.text = it.let {
                if (it.isSuccess) {
                    it.getOrNull()?.data?.toString()
                } else {
                    it.exceptionOrNull()?.localizedMessage
                }
            }
        })
        mViewModelCar.mLiveDataEngine.observe(this,{
            mTvInfo.text = it.let {
                if (it.isSuccess) {
                    it.getOrNull()?.data?.toString()
                } else {
                    it.exceptionOrNull()?.localizedMessage
                }
            }
        })
        mViewModelCar.mLiveDataCarFrame.observe(this,{
            mTvInfo.text = it.let {
                if (it.isSuccess) {
                    it.getOrNull()?.data.toString()
                }else{
                    it.exceptionOrNull()?.localizedMessage
                }
            }
        })
        mViewModelCar.mLiveDataWheel.observe(this,{
            mTvInfo.text = it.let {
                if (it.isSuccess) {
                    it.getOrNull()?.data?.toString()
                }else{
                    it.exceptionOrNull()?.localizedMessage
                }
            }
        })

        mViewModelWeather.mLiveDataWeather.observe(this,{
            mTvInfo.text = it.let {
                if (it.isSuccess) {
                    it.getOrNull()?.weatherinfo?.toString()
                }else{
                    it.exceptionOrNull()?.localizedMessage
                }
            }
        })
    }
    private fun initViews(){
        mBtn1.setOnClickListener { mViewModelCar.loadCar() }
        mBtn2.setOnClickListener { mViewModelCar.loadEngine() }
        mBtn3.setOnClickListener { mViewModelCar.loadCarFrame() }
        mBtn4.setOnClickListener { mViewModelCar.loadWheel() }

        mBtn5.setOnClickListener { mViewModelWeather.loadWeather() }
        mBtn6.setOnClickListener { mViewModelWeather.loadWeather("101280601") }
    }
}