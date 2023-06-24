package com.alie.modulepracticeflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alie.modulepracticeflow.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    val mainViewModel by viewModels<MainViewModel>()

   private val shareFlow = MutableSharedFlow<Int>()
    private val stateFlow = MutableStateFlow<Int>(1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).let {
            binding = it
            binding.root
        })

        initView()
        initObserve()
        stateFlow.value
    }

    private fun initView() {
        binding.btn1.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.login(this)
            }
        }

        binding.btn2.setOnClickListener {
            lifecycleScope.launch {
                shareFlow.emit(12)
            }
        }
    }

    private fun initObserve(){
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.loginUiState.collect{
                    binding.tv1.text = it
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                shareFlow.collect{
                    println("value = $it")
                }
            }
        }
    }
}