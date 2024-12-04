package io.github.junrdev.recycler.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class WasteData(
    val majorContent: String,
    val quantity: String,
    val contents: List<String>
) : Parcelable
