package com.alie.modulepracticemvvmframecoroutine.data.local

data class CarBean(
    var name:String? = "",
    var price:Float?= 0F,
    var engine: EngineBean?,
    var carFrame: CarFrameBean?,
    var wheel: WheelBean?)
