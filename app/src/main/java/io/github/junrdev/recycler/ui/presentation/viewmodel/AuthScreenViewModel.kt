package io.github.junrdev.recycler.ui.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.junrdev.recycler.domain.model.AppUser
import io.github.junrdev.recycler.domain.remote.FirebaseUserRepo
import kotlinx.coroutines.launch

class AuthScreenViewModel(
    private val firebaseUserRepo: FirebaseUserRepo
) : ViewModel() {


    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<AppUser> {
        return firebaseUserRepo.loginUserWithEmailAndPassword(email, password)
    }

    suspend fun signUpWithEmailAndPassword(email: String, password: String): Result<AppUser> {
        return firebaseUserRepo.registerUserWithEmail(email, password)
    }

    fun logoutUser() {
        viewModelScope.launch {
            firebaseUserRepo.logoutUser()
        }
    }

    suspend fun checkUserWithEmail(email: String): Boolean {
        val result = firebaseUserRepo.checkUserExistsWithEmail(email)

        return if (result.isSuccess)
            result.getOrThrow()
        else
            false
    }

    suspend fun checkUserWithPhone(phone: String): Boolean {
        val result = firebaseUserRepo.checkUserExistsWithPhone(phone)
        return if (result.isSuccess)
            result.getOrThrow()
        else
            false
    }

}