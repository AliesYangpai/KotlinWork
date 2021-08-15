package com.alie.modulepracticehilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alie.modulepracticehilt.mgr.MapManager
import com.alie.modulepracticehilt.mgr.SearchManager
import com.alie.modulepracticehilt.mgr.UserManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * field inject
     * @Inject is to work on with field inject but we still to let HILT to know how to provide di Item by @Inject
     * (in this case we can see we use construct inject【@Inject construct()】 to let HILT do by @Inject)
     *
     */
    @Inject lateinit var mSearchManager: SearchManager
    @Inject lateinit var mUserManager: UserManager
    @Inject lateinit var mMapManager: MapManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showData()
    }

    private fun showData() {
        test01() // 【HILT】filed inject & construct inject
        test02() // 【HILT】filed inject & construct inject & @Singleton
    }

    /**
     * 01
     * filed inject & construct inject
     */
    private fun test01() {
        println("===test01")
        mSearchManager.showInfo()
        mUserManager.showInfo()
        mMapManager.showInfo()
    }

    /**
     * 02
     * file inject & construct inject & @Singleton
     */
    private fun test02(){
        println("===test02")
        mMapManager.doWork()
        mUserManager.doWork()
    }
}