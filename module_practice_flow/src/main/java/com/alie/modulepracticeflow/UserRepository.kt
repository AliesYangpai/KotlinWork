package com.alie.modulepracticeflow

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UserRepository(private val userDataSource: UserDataSource) {


    fun login(name: String = "") = flow {
        emit(userDataSource.login(name))
    }.catch {
        emit(-1)
    }
}