package com.alie.modulepracticehilt.repo

import javax.inject.Inject
import javax.inject.Singleton

@Singleton // so In my options, this annotation is just an action scope for SearchRepo
class SearchRepo @Inject constructor():BaseRepo(){
    override fun getTargetData() {
        println("===getTargetData() ${this::class.java.simpleName}")
    }

}