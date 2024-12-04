package io.github.junrdev.recycler.ui.presentation.viewmodel

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import io.github.junrdev.recycler.domain.model.WasteData
import io.github.junrdev.recycler.domain.remote.GeminiRepo
import io.github.junrdev.recycler.util.Constants
import kotlinx.serialization.json.Json


private const val TAG = "ScanScreenViewModel"

class ScanScreenViewModel(
    private val geminiRepo: GeminiRepo,
    val defaultJson: Json
) : ViewModel() {


    suspend fun generateContentFromImage(image: Bitmap): WasteData? {

        val response = geminiRepo.generateFromTextAndImage(Constants.IMAGE_PROMPT, image)

        response.onFailure {
            return null
        }

        val decoded = defaultJson.decodeFromString<WasteData>(response.getOrNull().toString())
        Log.d(TAG, "generateContentFromImage: decoded $decoded")

        return decoded
    }

    suspend fun generateTextContent(prompt: String): String? {
        val response = geminiRepo.generateFromTextOnly(prompt)
        return response.getOrNull()
    }

}