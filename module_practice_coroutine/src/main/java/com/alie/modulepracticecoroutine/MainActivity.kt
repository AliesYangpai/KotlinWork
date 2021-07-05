package com.alie.modulepracticecoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/**
 * GlobalScope:Process级别,activity/fragment销毁了也存在
 * MainScope：在activity中使用，可以在onDestroy中取消协程
 * viewModelScope：只能在viewModel中使用，绑定viewModel声明周期
 * lifecycleScope：只能在activity、fragment中使用，绑定activity、fragment的生命周期
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBtn1.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val user= withContext(Dispatchers.IO) {
                    println("===OnClick~~~")
                    getUserData() }
                mTv1.text = user?.mName + user?.mAge
            }
        }
    }

    private suspend fun getUserData(): User {
        delay(5000)
       return User("西瓜", 16)
    }
}