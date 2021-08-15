package com.alie.modulepracticehilt.repo

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CalRouteRepo @Inject constructor():BaseRepo() {
    override fun getTargetData() {
        println("===getTargetData() ${this::class.java.simpleName}")
    }
}