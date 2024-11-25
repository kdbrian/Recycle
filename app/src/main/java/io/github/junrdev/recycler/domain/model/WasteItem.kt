package io.github.junrdev.recycler.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class WasteItem(
    val id: String = "",
    val recyclerId: String = "",
    val category: String = "",
    val quantity: Double = 0.0,
    val quantityUnit: String = "",
    val contents: String = "",
)

data class WasteDto(
    val category: String = "",
    val quantity: Double = 0.0,
    val quantityUnit: String = "",
    val contents: String = "",
)