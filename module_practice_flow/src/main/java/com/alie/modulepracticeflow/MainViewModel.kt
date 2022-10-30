package com.alie.modulepracticeflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val userRepository: UserRepository by lazy {
        UserRepository(UserDataSource())
    }

    private val _loginUiState = MutableStateFlow("")
    val loginUiState: StateFlow<String> = _loginUiState


    fun login(name: String = "") {
        viewModelScope.launch {
            userRepository.login(name).collectLatest {
                println("===login data $it")
                _loginUiState.value = when {
                    it == -1 -> "error"
                    it % 2 == 0 -> "double"
                    else -> "single"
                }
            }
        }
    }
}