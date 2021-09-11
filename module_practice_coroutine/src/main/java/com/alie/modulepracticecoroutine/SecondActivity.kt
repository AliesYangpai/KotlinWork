package com.alie.modulepracticecoroutine

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.alie.modulepracticecoroutine.data.CpuBean
import com.alie.modulepracticecoroutine.repo.RepoComputer
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * GlobalScope:Process级别,activity/fragment销毁了也存在
 * MainScope：在activity中使用，可以在onDestroy中取消协程
 * viewModelScope：只能在viewModel中使用，绑定viewModel声明周期
 * lifecycleScope：只能在activity、fragment中使用，绑定activity、fragment的生命周期
 */
class SecondActivity : AppCompatActivity() {

    private val mRepoComputer by lazy { RepoComputer() }

    private var mCpuBean = CpuBean("xx")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        mBtnComputer.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                println("launch computer start :${Thread.currentThread().name}")
                val computer = withContext(Dispatchers.IO) {
                    println("launch computer execute :${Thread.currentThread().name}")
                    mRepoComputer.loadComputer()
                }
                println("launch computer end :${Thread.currentThread().name}")
                mTvInfo.text =
                    computer?.mCpuBean?.mName + computer?.mGpuBean?.mName + computer?.mMemoryBean?.mName
            }

        }
        mBtnCpu.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) { mRepoComputer.loadCpuBean() }.let {
                    mTvInfo.text = it?.mName
                }
            }

        }
        mBtnGpu.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) { mRepoComputer.loadGpuBean() }.let {
                    mTvInfo.text = it?.mName
                }
            }
        }
        mBtnMemory.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) { mRepoComputer.loadMemoryBean() }.let {
                    mTvInfo.text = it?.mName
                }
            }
        }
        doCheckParamPassIn() // 验证~~~~
    }


    /**
     * 验证：
     * 传参后，外部对象类型重新实例化后，已经传入方法的外部对象，在方法中是否也自动变成新的了
     * SUMMARY: 方法内不会变，除非重新传入
     * 原因：即便传入的是对象类型（实际上传入的是对象地址），那么在方法内部会【复制一份参数地址，也可以理解为对参数复制一份】，因此
     * 方法内部操作的都是副本。外部对象地址变化后【注意 一定是地址变化，而不是解引用的变化】，如不再次调用用一下方法，则此时方法
     * 中操作的对象地址仍是变化之前的地址
     */
    private fun doCheckParamPassIn() {
        mBtnHashCode.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                showHashCode(mCpuBean)
            }
        }
        mBtnGenerateNew.setOnClickListener {
            generateCpuBean()
        }
    }

    private suspend fun showHashCode(cpuBean: CpuBean) {
        try {
            println("===hashCode HashCode:${cpuBean.hashCode()}")
            delay(2000)
            println("===hashCode HashCode:${cpuBean.hashCode()}")
        } catch (e: Exception) {
            println("===hashCode msg:${e.message}")
        }
    }

    fun generateCpuBean() {
        mCpuBean = CpuBean("xxx")
        println("===hashCode generateCpuBean:${mCpuBean.hashCode()}")
    }
}