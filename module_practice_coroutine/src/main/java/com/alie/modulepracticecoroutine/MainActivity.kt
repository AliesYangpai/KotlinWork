package com.alie.modulepracticecoroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.UiThread
import androidx.lifecycle.lifecycleScope
import com.alie.modulepracticecoroutine.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread
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
        binding.mBtnTestRunBlock.setOnClickListener {
//            test06()
//            test07()
            test08()
        }
        binding.mBtnTestRunBlock2.setOnClickListener {
            test09()
        }

        binding.mBtnTestCoroutine3.setOnClickListener {
            test10()
        }
        initTestWork()
    }


    private fun initTestWork() {
//        test01() // 协程异常-job()
//        test02() // 协程异常-SupervisorJob()
        test03() // 协程异常-supervisorScope{}
        test04() // 这俩个方法说明 launch中传入的dispatch 会生成一个新的job 不同于parent
        test05() // 这俩个方法说明 launch中传入的dispatch 会生成一个新的job 不同于parent
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
        val scope = CoroutineScope(Job() + Dispatchers.Main)

        val job1 = scope.launch(Dispatchers.IO) {
        }
        println("test04 parentjob:${scope.coroutineContext.job.hashCode()} job1: ${job1.hashCode()}")
    }


    private fun test05() {
        val job1 = CoroutineScope(Job() + Dispatchers.Main).launch {
            println("test05 do in launch job:${coroutineContext.job.hashCode()}")
        }
        println("test05 launch return job1:${job1.hashCode()}")
    }

    /**
     * test runBlocking
     * 这里的runBlocking阻塞的是当前线程（此代码块运行在哪个线程，就阻塞哪个线程），从其中的源码中就可以看到
     * 这个依靠的是当前线程的阻塞
     */
    private fun test06() {
        runBlocking {
            launch {
//                delay(1000)
                println("test06 hello")
            }
            println("test06 world")
        }
        println("test06 this out of runBlocking")
    }

    private fun test07() {
        runBlocking {
            coroutineScope {
                launch{
                    delay(2000)
                    println("test07 coroutineScope world1 thread")
                }
                launch {
                    delay(1000)
                    println("test07 coroutineScope world2 thread")
                }
                delay(3000)
                println("test07 coroutineScope hello thread")
            }
            println("test07 out of coroutineScope world thread")
        }
    }

    private fun test08 () {
        lifecycleScope.launch {

            testDelayA()
            testDelayB()
            delay(2000)
            println("test08 hello thread:${Thread.currentThread().name}")
        }
        println("test08 out of launch thread:${Thread.currentThread().name}")
    }

    private suspend fun testDelayA(){
        coroutineScope {
            delay(1000)
            println("test08 testDelayA thread:${Thread.currentThread().name}")
        }
    }

    private suspend fun testDelayB(){
        coroutineScope{
            delay(2000)
            println("test08 testDelayB thread:${Thread.currentThread().name}")
        }
    }

    private fun test09() {
        runBlocking {
            test09A()
            test09B()
            println("test09 hello ")
        }
        println("test09 out of runBlocking")
    }

    private suspend fun test09A() {
        delay(1000)
        println("test09A ")
    }

    private suspend fun test09B() {
        delay(1000)
        println("test09B ")
    }


    private fun test10() {
        lifecycleScope.launch {
            test10a(this)
            test10b(this)
        }
    }

    private suspend fun test10a(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            delay(2000)
            println("test10a delay finish")
        }
        println("test10a")
    }

    private suspend fun test10b(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            delay(1000)
            println("test10b delay finish")
        }
        println("test10b")
    }
}