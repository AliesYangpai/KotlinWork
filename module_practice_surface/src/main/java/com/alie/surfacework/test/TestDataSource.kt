package com.alie.surfacework.test

import com.alie.surfacework.test.entity.TestPerson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestDataSource @Inject constructor() {

    fun getTestData01(): TestPerson {
       return TestPerson("waterMellon",12,"guagua")
    }

    fun getTestDataList():List<TestPerson> {
       val a = TestPerson("waterMellon",12,"guagua")
       val b=TestPerson("cumcumber",12,"cum")
       val c= TestPerson("apple",12,"apple")
        return listOf(a,b,c)
    }


}

