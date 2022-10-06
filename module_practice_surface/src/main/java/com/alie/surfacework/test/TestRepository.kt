package com.alie.surfacework.test


import com.alie.surfacework.test.entity.TestPerson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(
    private val testDataSource: TestDataSource
) {


    fun getTestData01(): TestPerson = testDataSource.getTestData01()

    fun getTestDataList():List<TestPerson> = testDataSource.getTestDataList()
}