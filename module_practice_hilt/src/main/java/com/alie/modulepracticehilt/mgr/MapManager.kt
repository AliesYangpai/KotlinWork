package com.alie.modulepracticehilt.mgr

import com.alie.modulepracticehilt.repo.CalRouteRepo
import com.alie.modulepracticehilt.repo.LocationRepo
import com.alie.modulepracticehilt.repo.SearchRepo
import javax.inject.Inject

class MapManager @Inject constructor(
    private val mLocationRepo: LocationRepo,
    private val mSearchRepo: SearchRepo,
    private val mCalRouteRepo: CalRouteRepo
) : BaseManager() {
    override fun showInfo() {
        println("===showInfo() ${this::class.java.simpleName}")
    }

    override fun doWork() {
        mLocationRepo.getTargetData()
        mSearchRepo.getTargetData()
        mCalRouteRepo.getTargetData()
    }
}