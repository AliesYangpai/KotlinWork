package com.alie.surfacework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alie.surfacework.databinding.ActivityMainBinding
import com.alie.surfacework.test.TestActivity
import com.alie.surfacework.test.TestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).let {
            binding = it
            it.root
        })
        initObserver()
        initView()

    }

    private fun initView() {
        binding.btnOpenCamera.setOnClickListener {
            mainViewModel.startCamera()
        }

        binding.btnOpenLight.setOnClickListener {
            mainViewModel.startLightBreath()
        }
        binding.btn3.setOnClickListener {
//            mainViewModel.test01ThreadAndLiveData()
//            mainViewModel.testDataListThreadAndLiveData()
            mainViewModel.testDataListFlowAnsLiveData()
        }
        binding.btn4.setOnClickListener {
            startActivity(Intent(this,TestActivity::class.java))
        }
    }


    private fun initTestObserver() {
        mainViewModel.testLiveData.observe(this) {
            println("initTestObserver testPerson $it thread:${Thread.currentThread().name}")
        }
        mainViewModel.testListLiveData.observe(this) {
            it.forEach { testPerson ->
                println("initTestObserver testPerson name:${testPerson.name} thread:${Thread.currentThread().name}")
            }
        }
    }


    private fun initObserver() {
        initTestObserver()
    }
}