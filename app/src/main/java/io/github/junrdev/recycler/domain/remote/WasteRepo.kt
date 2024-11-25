package io.github.junrdev.recycler.domain.remote

import io.github.junrdev.recycler.domain.model.WasteDto
import io.github.junrdev.recycler.domain.model.WasteItem

interface WasteRepo {
    suspend fun addToDb(wasteItem: WasteDto, appUserId: String):Result<WasteItem>
    suspend fun getFromDb(appUserId: String): Result<List<WasteItem>>
}