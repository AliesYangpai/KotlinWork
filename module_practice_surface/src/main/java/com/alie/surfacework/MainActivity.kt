package com.alie.surfacework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.alie.surfacework.databinding.ActivityMainBinding
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
        initView()
        initData()
    }

    private fun initView() {
        binding.btnOpenCamera.setOnClickListener {
            mainViewModel.startCamera()
        }

        binding.btnOpenLight.setOnClickListener {
            mainViewModel.startLightBreath()
        }
    }

    private fun initData() {
    }
}