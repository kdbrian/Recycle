package io.github.junrdev.recycler.domain.remote

import io.github.junrdev.recycler.domain.model.AppUser

interface FirebaseUserRepo {

    suspend fun loginUserWithEmailAndPassword(email : String, password : String) : Result<String>

    suspend fun loginUserWithPhoneNumber(phone : String) : Result<String>

    suspend fun checkUserExistsWithEmail(email: String) : Result<Boolean>

    suspend fun checkUserExistsWithPhone(phone: String)  : Result<Boolean>

    suspend fun registerUserWithEmail(email : String, password : String)  : Result<String>

    suspend fun registerUserWithPhoneNumber(phone : String) : Result<String>

    suspend fun logoutUser()  : Result<String>

}