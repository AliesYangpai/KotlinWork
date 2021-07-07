package com.alie.modulepracticemvvmframe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alie.modulepracticemvvmframe.viewmodel.CarViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mCarViewModel by viewModels<CarViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObserve()
        initViews()
    }

    @SuppressLint("SetTextI18n")
    private fun initObserve() {
        mCarViewModel.mCarLiveData.observe(this,{
            mTvInfo.text = it.mEngineBean?.mName+ it.mCarFrameBean?.mName+it.mWheelBean?.mName
        })

        mCarViewModel.mEngineLiveData.observe(this,{
            mTvInfo.text = it.mName
        })
        mCarViewModel.mCarFrameLiveData.observe(this,{
            mTvInfo.text = it.mName
        })
        mCarViewModel.mWheelLiveData.observe(this,{
            mTvInfo.text = it.mName
        })
    }

    private fun initViews() {
        mBtn1.setOnClickListener {
            mCarViewModel.loadDataCar()
        }
        mBtn2.setOnClickListener { mCarViewModel.loadDataEngine() }
        mBtn3.setOnClickListener { mCarViewModel.loadDataCarFrame() }
        mBtn4.setOnClickListener { mCarViewModel.loadDataWheel() }
    }
}