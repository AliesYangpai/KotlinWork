package com.alie.modulepracticemvvmframecoroutine.data.http

data class HttpThirdResponse<T> (var code:Int = -1,var msg:String? = "",var weatherinfo:T?){
}