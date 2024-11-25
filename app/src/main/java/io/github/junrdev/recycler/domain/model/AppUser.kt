package io.github.junrdev.recycler.domain.model

data class AppUser(
    val userId: String = "",
    val email: String? = null,
    val phone: String? = null,
    val recyclerId: String = "",
    val pointAccumulated: Long = 0L,
    val dateJoined: String? = null,
    val registrationMode: REGISTRATION_MODE
)


enum class REGISTRATION_MODE {
    EMAIL_PASSWORD,
    GOOGLE_SIGN_IN,
    PHONE_NUMBER
}

data class RecycledWaste(
    val wasteId: String,
    val wasteName: String,
    val quantity: String,
    val recyclerId: String,
)