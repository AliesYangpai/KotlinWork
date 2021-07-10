package com.alie.modulepracticemvvmframecoroutine.repo

import com.alie.modulepracticemvvmframecoroutine.data.CarBean
import com.alie.modulepracticemvvmframecoroutine.data.CarFrameBean
import com.alie.modulepracticemvvmframecoroutine.data.EngineBean
import com.alie.modulepracticemvvmframecoroutine.data.WheelBean

class RepoCar {
    fun loadDataCar():CarBean?{
        return CarBean(loadDataEngine(),loadDataCarFrame(),loadDataWheel())
    }
    fun loadDataEngine():EngineBean?{
        return EngineBean("Engine:Ferrari V12")
    }
    fun loadDataCarFrame():CarFrameBean?{
        return CarFrameBean("CarFrame:Ferrari 001")
    }
    fun loadDataWheel():WheelBean?{
        return WheelBean("Bridge Stone rainy")
    }
}