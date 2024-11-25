package io.github.junrdev.recycler.domain.model

import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

@Serializable
data class AppUser(
    val userId: String = "",
    val email: String? = null,
    val phone: String? = null,
    val recyclerId: String = "",
    val pointAccumulated: Long = 0L,
    val dateJoined: String? = LocalDateTime.now().toString(),
    val registrationMode: REGISTRATION_MODE=REGISTRATION_MODE.DEFAULT
)


enum class REGISTRATION_MODE {
    DEFAULT,
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