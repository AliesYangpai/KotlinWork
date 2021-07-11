package com.alie.modulepracticemvvmframecoroutine.data.http

data class HttpResponse<T>(val code:Int = -1, val msg:String? = "",val data:T?)