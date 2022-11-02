package com.alie.modulepracticeflow

import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val userDataSource: UserDataSource) {


    fun login(name: String = "") = flow {
        emit(userDataSource.login(name))
    }.catch {
        emit(-1)
    }.flowOn(Dispatchers.IO)
}