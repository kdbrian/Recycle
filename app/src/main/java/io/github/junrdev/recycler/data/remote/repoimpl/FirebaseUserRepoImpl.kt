package io.github.junrdev.recycler.data.remote.repoimpl

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.github.junrdev.recycler.domain.model.AppUser
import io.github.junrdev.recycler.domain.model.REGISTRATION_MODE
import io.github.junrdev.recycler.domain.remote.FirebaseUserRepo
import io.github.junrdev.recycler.util.Constants
import kotlinx.coroutines.tasks.await

class FirebaseUserRepoImpl : FirebaseUserRepo {

    private val auth = Firebase.auth
    private val usersCollection = Firebase.firestore.collection(Constants.usersCollection)
    private val recycleCollection = Firebase.firestore.collection(Constants.wasteMetadataCollection)


    override suspend fun loginUserWithEmailAndPassword(
        email: String,
        password: String
    ): Result<AppUser> {

        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            if (result.user != null) {
                val userId = result.user?.uid

                val doc = usersCollection.document(userId.toString())
                    .get()
                    .await()

                if (doc != null) {
                    val user = doc.toObject(AppUser::class.java)
                    Result.success(user!!)
                } else
                    Result.failure(Exception("Failed to fetch account."))
            } else
                Result.failure(Exception("Failed to fetch account."))
        } catch (e: Exception) {
            Result.failure(e)
        }


    }

    override suspend fun loginUserWithPhoneNumber(phone: String): Result<String> {
        return Result.success("Am a Tea pot.")
    }

    override suspend fun checkUserExistsWithEmail(email: String): Result<Boolean> {
        return try {
            val queryResult = usersCollection.where(Filter.equalTo("email", email))
                .get().await()

            Result.success(!queryResult.isEmpty)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun checkUserExistsWithPhone(phone: String): Result<Boolean> {
        return try {
            val queryResult = usersCollection.whereEqualTo("phone", phone)
                .get().await()

            Result.success(!queryResult.isEmpty)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun registerUserWithEmail(email: String, password: String): Result<AppUser> {
        return try {
            val registerResult = auth.createUserWithEmailAndPassword(email, password)
                .await()

            if (registerResult.user != null) {

                val userId = registerResult.user?.uid.toString()
                val recyclerId = recycleCollection.document()

                val userRef = usersCollection.document(userId)

                val user = AppUser(
                    email = email,
                    userId = userId,
                    recyclerId = recyclerId.id,
                    registrationMode = REGISTRATION_MODE.EMAIL_PASSWORD
                )

                userRef.set(user).await()

                Result.success(user)

            } else
                Result.failure(Exception("Failed to create account, try again."))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun registerUserWithPhoneNumber(phone: String): Result<AppUser> {
        return Result.failure(Exception("Am a Tea pos"))
    }

    override suspend fun logoutUser(): Result<String> {
        return if (auth.currentUser != null) {
            auth.signOut()
            Result.success("Success")
        } else
            Result.success("Something unexpected happened.")
    }

}