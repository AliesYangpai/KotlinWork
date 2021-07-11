package com.alie.modulepracticemvvmframecoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alie.modulepracticemvvmframecoroutine.viewmodel.ViewModelCar
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {


    private val mViewModelCar by viewModels<ViewModelCar>()


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
    }
    private fun initViews(){
        mBtn1.setOnClickListener { mViewModelCar.loadCar() }
        mBtn2.setOnClickListener { mViewModelCar.loadEngine() }
        mBtn3.setOnClickListener { mViewModelCar.loadCarFrame() }
        mBtn4.setOnClickListener { mViewModelCar.loadWheel() }
    }
}