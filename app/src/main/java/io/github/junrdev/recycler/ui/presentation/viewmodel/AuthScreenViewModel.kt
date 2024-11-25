package io.github.junrdev.recycler.ui.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.junrdev.recycler.domain.remote.FirebaseUserRepo
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AuthScreenViewModel(
    private val firebaseUserRepo: FirebaseUserRepo
) : ViewModel() {


    suspend fun signInWithEmailAndPassword(email: String, password: String): String {
        val result = viewModelScope.async {
            firebaseUserRepo.loginUserWithEmailAndPassword(email, password)
        }.await()

        return if (result.isSuccess) {
            result.getOrNull().toString()
        } else {
            println("failed login : " + result.exceptionOrNull()?.message)
            result.exceptionOrNull()?.message.toString()
        }
    }

    suspend fun signUpWithEmailAndPassword(email: String, password: String): String {
        val result = firebaseUserRepo.registerUserWithEmail(email, password)
        return if (result.isSuccess)
            result.getOrNull().toString()
        else
            result.exceptionOrNull()?.message.toString()
    }

    fun logoutUser() {
        viewModelScope.launch {
            firebaseUserRepo.logoutUser()
        }
    }

}