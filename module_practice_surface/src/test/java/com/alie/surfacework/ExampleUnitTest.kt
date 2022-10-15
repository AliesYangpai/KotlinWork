package com.alie.surfacework

import kotlinx.coroutines.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test01() {
//       val scope = CoroutineScope(Job()+Dispatchers.Main)
//        scope.launch {
//            printData("test01")
//        }
    }

    private suspend fun printData(tip:String) {
        withContext(Dispatchers.IO) {
            println(" $tip thread current thread ${Thread.currentThread().name}")
        }
        println()
    }
}