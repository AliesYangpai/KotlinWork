package com.alie.kotlinwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alie.kotlinwork.data.UserData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   @Inject lateinit var mUserData:UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doShow()
    }

    private fun doShow() {
        mUserData.let {
            it.showInfo()
            it.showExtraInfo()
        }

    }
}