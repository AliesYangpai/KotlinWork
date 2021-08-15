package com.alie.modulepracticehilt.mgr

abstract class BaseManager {
    fun showCommonInfo() {
        println("===showCommonInfo() ${this::class.java.simpleName}")
    }

    abstract fun showInfo()

    abstract fun doWork()
}