package com.alie.modulepracticemvvmframe.repo

import com.alie.modulepracticemvvmframe.data.CarBean
import com.alie.modulepracticemvvmframe.data.CarFrameBean
import com.alie.modulepracticemvvmframe.data.EngineBean
import com.alie.modulepracticemvvmframe.data.WheelBean

class RepoCar {
    fun loadCarBean():CarBean? {
        return CarBean(loadEngineBean(),loadCarFrameBean(),loadWheelBean())
    }

    fun loadEngineBean():EngineBean? = EngineBean(" Engine Ferrari v12")
    fun loadCarFrameBean():CarFrameBean? = CarFrameBean(" CarFrame Ferrari 001")
    fun loadWheelBean():WheelBean? = WheelBean(" Wheel BridgeStone rainy")
}