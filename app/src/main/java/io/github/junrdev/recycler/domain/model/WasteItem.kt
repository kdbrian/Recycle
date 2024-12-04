package io.github.junrdev.recycler.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class WasteItem(
    val id: String = "",
    val recyclerId: String = "",
    val wasteData: WasteData
)

data class WasteDto(
    val category: String = "",
    val wasteData: WasteData,
)