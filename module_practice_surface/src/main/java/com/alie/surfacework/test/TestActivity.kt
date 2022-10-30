package com.alie.surfacework.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.alie.surfacework.databinding.ActivityTestBinding
import com.alie.surfacework.test.entity.TestPerson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    private val testViewModel: TestViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityTestBinding.inflate(layoutInflater).let {
            binding = it
            binding.root
        })

        initData()
    }

    private fun initData() {
        CoroutineScope(Job()+Dispatchers.Main)
    }
}
