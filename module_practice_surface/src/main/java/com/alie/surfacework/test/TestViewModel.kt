package com.alie.surfacework.test

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor() :ViewModel() {


    fun testWork01() {
        val coroutine = CoroutineScope(Job()+Dispatchers.Main)
        coroutine.launch {
            println("testWork01 this is first currentThread:${Thread.currentThread().name}")
        }
    }

    fun testWork02(){}

}