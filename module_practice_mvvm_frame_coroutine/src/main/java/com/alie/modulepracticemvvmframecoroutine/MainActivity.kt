package com.alie.modulepracticemvvmframecoroutine

import android.annotation.SuppressLint
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

    @SuppressLint("SetTextI18n")
    fun initObserve() {
        mViewModelCar.mLiveDataCar.observe(this,{ mTvInfo.text = it?.mCarFrameBean?.mName+it?.mEngineBean?.mName+it?.mWheelBean?.mName })
        mViewModelCar.mLiveDataEngine.observe(this,{mTvInfo.text = it?.mName})
        mViewModelCar.mLiveDataCarFrame.observe(this,{mTvInfo.text = it?.mName})
        mViewModelCar.mLiveDataWheel.observe(this,{mTvInfo.text = it?.mName})
    }
    fun initViews(){
        mBtn1.setOnClickListener { mViewModelCar.loadCar() }
        mBtn2.setOnClickListener { mViewModelCar.loadEngine() }
        mBtn3.setOnClickListener { mViewModelCar.loadCarFrame() }
        mBtn4.setOnClickListener { mViewModelCar.loadWheel() }
    }
}