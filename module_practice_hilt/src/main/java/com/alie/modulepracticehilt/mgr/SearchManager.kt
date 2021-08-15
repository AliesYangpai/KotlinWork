package com.alie.modulepracticehilt.mgr

import com.alie.modulepracticehilt.repo.LocationRepo
import com.alie.modulepracticehilt.repo.SearchRepo
import javax.inject.Inject

class SearchManager @Inject constructor(
    private val mSearchRepo: SearchRepo,
    private val mLocationRepo: LocationRepo
) : BaseManager() {
    override fun showInfo() {
        println("===showInfo() ${this::class.java.simpleName}")
    }

    override fun doWork() {
        mSearchRepo.getTargetData()
        mLocationRepo.getTargetData()
    }
}