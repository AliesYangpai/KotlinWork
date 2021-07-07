package com.alie.modulepracticecoroutine.repo

import com.alie.modulepracticecoroutine.data.ComputerBean
import com.alie.modulepracticecoroutine.data.CpuBean
import com.alie.modulepracticecoroutine.data.GpuBean
import com.alie.modulepracticecoroutine.data.MemoryBean
import kotlinx.coroutines.delay

class RepoComputer {
    suspend fun loadCpuBean():CpuBean? {
        delay(3000)
        return CpuBean("cpu Alienware")
    }

    suspend fun loadGpuBean():GpuBean? {
        delay(3000)
        return GpuBean("gpu Alienware")
    }

    suspend fun loadMemoryBean():MemoryBean? {
        delay(3000)
        return  MemoryBean("memory Dell")
    }

    suspend fun loadComputer():ComputerBean? {
        return ComputerBean(loadCpuBean(),loadGpuBean(),loadMemoryBean())
    }
}