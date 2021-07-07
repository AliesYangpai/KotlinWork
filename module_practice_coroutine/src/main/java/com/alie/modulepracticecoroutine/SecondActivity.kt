package com.alie.modulepracticecoroutine

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.alie.modulepracticecoroutine.repo.RepoComputer
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.Dispatchers
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
                mTvInfo.text = computer?.mCpuBean?.mName + computer?.mGpuBean?.mName+computer?.mMemoryBean?.mName
            }

        }
        mBtnCpu.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO){mRepoComputer.loadCpuBean()}.let { mTvInfo.text = it?.mName }
            }

        }
        mBtnGpu.setOnClickListener {
            lifecycleScope.launch  (Dispatchers.Main){
                withContext(Dispatchers.IO){mRepoComputer.loadGpuBean()}.let { mTvInfo.text = it?.mName }
            }
        }
        mBtnMemory.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {mRepoComputer.loadMemoryBean()}.let { mTvInfo.text = it?.mName }
            }
        }
    }


}