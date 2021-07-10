package com.alie.modulepracticemvvmframecoroutine.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHttpClient {
    private var mRetrofit: Retrofit? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(ConstHttpUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    companion object {
        private var mInstance:ApiHttpClient ? = null
        fun getInstance():ApiHttpClient {
            return mInstance ?: synchronized(this){
                mInstance ?: ApiHttpClient().also {
                    mInstance = it
                }
            }
        }
    }

    fun <T> generateService(clazz: Class<T>) = mRetrofit?.create(clazz)
}