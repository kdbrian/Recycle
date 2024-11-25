package io.github.junrdev.recycler.data.remote.repoimpl

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import io.github.junrdev.recycler.domain.model.WasteDto
import io.github.junrdev.recycler.domain.model.WasteItem
import io.github.junrdev.recycler.domain.remote.WasteRepo
import io.github.junrdev.recycler.util.Constants
import kotlinx.coroutines.tasks.await

class WasteRepoImpl : WasteRepo {

    private val wasteCollection = Firebase.firestore.collection(Constants.wasteMetadataCollection)

    override suspend fun addToDb(wasteItem: WasteDto, appUserId: String): Result<WasteItem> {
        return try {
            val docRef = wasteCollection.document()
            val waste = WasteItem(
                recyclerId = appUserId,
                id = docRef.id,
                contents = wasteItem.contents,
                category = wasteItem.category,
                quantity = wasteItem.quantity,
                quantityUnit = wasteItem.quantityUnit
            )
            docRef.set(waste).await()
            Result.success(waste)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFromDb(appUserId: String): Result<List<WasteItem>> {
        return try {
            val docs = wasteCollection.whereEqualTo("recyclerId", appUserId)
                .get().await()
            if (docs == null || docs.isEmpty)
                Result.failure(Exception("No items found."))
            else {
                val wasteDocs = docs.toObjects(WasteItem::class.java)
                Result.success(wasteDocs)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}