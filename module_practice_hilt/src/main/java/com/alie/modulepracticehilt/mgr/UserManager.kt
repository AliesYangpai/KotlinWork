package com.alie.modulepracticehilt.mgr

import com.alie.modulepracticehilt.repo.LocationRepo
import javax.inject.Inject

class UserManager @Inject constructor(val mLocationRepo: LocationRepo): BaseManager() {
    override fun showInfo() {
        println("===showInfo() ${this::class.java.simpleName}")
    }

    override fun doWork() {
        mLocationRepo.getTargetData()
    }
}