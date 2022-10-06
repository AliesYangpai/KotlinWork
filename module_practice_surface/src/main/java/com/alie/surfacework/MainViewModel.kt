package com.alie.surfacework


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alie.surfacework.data.SurfaceRepository
import com.alie.surfacework.test.TestRepository
import com.alie.surfacework.test.entity.TestPerson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.concurrent.thread

@HiltViewModel
class MainViewModel @Inject constructor(
    private val surfaceRepository: SurfaceRepository,
    private val testRepository: TestRepository
) : ViewModel() {

    private val _testLiveData:MutableLiveData<TestPerson> = MutableLiveData()
    val testLiveData:LiveData<TestPerson> = _testLiveData

    private val _testListLiveData:MutableLiveData<List<TestPerson>> = MutableLiveData()
    val testLiveDataList:LiveData<List<TestPerson>> = _testListLiveData
    fun startLightBreath() {
        surfaceRepository.fetchLightType()
    }

    fun startCamera() {
        surfaceRepository.fetchCameraData()
    }

    fun test01ThreadAndLiveData() {
        thread {
            val data = testRepository.getTestData01()
            _testLiveData.postValue(data)
            println("test01ThreadAndLiveData testPerson thread:${Thread.currentThread().name}")
        }
    }

    fun testDataListThreadAndLiveData() {
        thread {
            _testListLiveData.postValue(testRepository.getTestDataList().filter {
                println("testDataListThreadAndLiveData testPerson thread:${Thread.currentThread().name}")
                it.name.contains("a")
            })
        }
    }
}