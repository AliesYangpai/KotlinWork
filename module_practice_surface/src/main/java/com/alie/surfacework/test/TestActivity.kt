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
        initListener()
        initObserver()
        initTestWork()
    }

    private fun initTestWork() {
        testViewModel.testWork01()
    }

    private fun initObserver() {

    }

    private fun initListener() {
        binding.btn1.setOnClickListener {
            doTestRawCoroutine01()

        }
    }

    /**
     * 01使用GlobalScope创建一个协程
     */
    private fun doTestRawCoroutine01(){
        GlobalScope.launch(Dispatchers.Main) {  // 01 在主线程上启动一个协程
           val data = subRaw01()                // 02 遇到suspend方法，挂起调用此方法的协程块儿
            println("$data")                        // 03 suspend函数将会在指定的线程中执行
        }                                           // 04 执行完成后 调用调度器再将协程恢复
    }

    private suspend fun subRaw01() {
        withContext(Dispatchers.IO){
            println()
        }
    }

    /**
     * 自定义协程
     */
    private fun doTestRawCoroutine02() {
        val scope = CoroutineScope(Job()+Dispatchers.Main)
        scope.launch {
           val data = subRaw01()
            println("$data")
        }

        scope.cancel() //取消协程
    }
}
