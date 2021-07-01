package com.alie.kotlinwork.data

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserData @Inject constructor() {
    fun showInfo() {
        println("===UserData showInfo")
    }

    fun showExtraInfo() {
        println("===UserData showExtraInfo")
    }
}