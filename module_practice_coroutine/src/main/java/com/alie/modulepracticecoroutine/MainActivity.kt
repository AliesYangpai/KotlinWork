package com.alie.modulepracticecoroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import com.alie.modulepracticecoroutine.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

/**
 * GlobalScope:Process级别,activity/fragment销毁了也存在
 * MainScope：在activity中使用，可以在onDestroy中取消协程
 * viewModelScope：只能在viewModel中使用，绑定viewModel声明周期
 * lifecycleScope：只能在activity、fragment中使用，绑定activity、fragment的生命周期
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).let {
            binding = it
            it.root
        })
        binding.mBtnJump.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SecondActivity::class.java
                )
            )
        }
        initTestWork()
    }

    private fun initTestWork() {
//        test01() // 协程异常-job()
//        test02() // 协程异常-SupervisorJob()
        test03() // 协程异常-supervisorScope{}
        test04()
        test05()
    }


    /**
     * test01
     * job()
     * child异常-Scope-other child
     */
    private fun test01() {
        val scope =
            CoroutineScope(Job() + Dispatchers.Main + CoroutineExceptionHandler { coroutineContext, throwable ->
                println(" test01 error ${throwable.message}")
            })
        scope.launch {
            println("test01 1")
            val data = 5 / 0
        }
        scope.launch {
            println("test01 2")
        }

        scope.launch {
            println("test01 3")
        }
        scope.launch {
            println("test01 4")
        }
    }

    /**
     * test02
     * SupervisorJob()
     * child异常---Scope 不通知 other child
     */
    private fun test02() {
        val scope =
            CoroutineScope(SupervisorJob() + Dispatchers.Main + CoroutineExceptionHandler { coroutineContext, throwable ->
                println(" test02 error ${throwable.message}")
            })
       val job = scope.launch {
            println("test02 1")
            val data = 5 / 0
        }
        scope.launch {
            println("test02 2")
        }

        scope.launch {
            println("test02 3")
        }
        scope.launch {
            println("test02 4")
        }


        job.cancel()
    }

    private fun test03() {

        CoroutineScope(Job() + Dispatchers.Main + CoroutineExceptionHandler { coroutineContext, throwable ->
            println("test03 error ${throwable.message} thread:${Thread.currentThread().name}")
        }).launch {
            supervisorScope {
                launch(Dispatchers.Default) {
                    println("test03 1 thread:${Thread.currentThread().name}")
                    val data = 3 / 0
                }
                println("test03 2 thread:${Thread.currentThread().name}")
            }
        }
    }

    private fun test04() {
      val scope =  CoroutineScope(Job()+Dispatchers.Main)

       val job1 = scope.launch(Dispatchers.IO) {
        }
        println("test04 parentjob:${scope.coroutineContext.job.hashCode()} job1: ${job1.hashCode()}")
    }


    private fun test05() {
        val job1 = CoroutineScope(Job()+Dispatchers.Main).launch {
            println("test05 do in launch job:${coroutineContext.job.hashCode()}")
        }
        println("test05 launch return job1:${job1.hashCode()}")
    }

}